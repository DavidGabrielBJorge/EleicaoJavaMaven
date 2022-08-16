package br.edu.iftm.upt.justificativa.validation.validator;

import java.lang.reflect.Field;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.edu.iftm.upt.justificativa.validation.AtributosIguais;

public class AtributosIguaisValidator implements ConstraintValidator<AtributosIguais, Object> {

	private String atributo1;
	private String atributo2;
	private String message;

	@Override
	public void initialize(final AtributosIguais constraintAnnotation) {
		atributo1 = constraintAnnotation.atributo1();
		atributo2 = constraintAnnotation.atributo2();
		message = constraintAnnotation.message();
	}

	@Override
	public boolean isValid(final Object value, final ConstraintValidatorContext context) {
		boolean valido = true;
		try {
			Field field1 = value.getClass().getDeclaredField(atributo1);
			field1.setAccessible(true);
			final Object valor1 = field1.get(value);
			Field field2 = value.getClass().getDeclaredField(atributo2);
			field2.setAccessible(true);
			final Object valor2 = field2.get(value);
			
//			import org.springframework.beans.BeanWrapperImpl;
//			final Object firstObj = new BeanWrapperImpl(value).getPropertyValue(atributo1);
//			final Object secondObj = new BeanWrapperImpl(value).getPropertyValue(atributo2);

			valido =  valor1 == null && valor2 == null || valor1 != null && valor1.equals(valor2);
		} catch (final Exception ignore) {
			// we can ignore
		}

		if (!valido){
			context.buildConstraintViolationWithTemplate(message)
				.addPropertyNode(atributo1)
				.addConstraintViolation()
				.disableDefaultConstraintViolation();
		}

		return valido;
	}
}