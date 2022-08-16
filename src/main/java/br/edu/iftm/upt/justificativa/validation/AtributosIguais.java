package br.edu.iftm.upt.justificativa.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.edu.iftm.upt.justificativa.validation.validator.AtributosIguaisValidator;

@Constraint(validatedBy = AtributosIguaisValidator.class)
@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AtributosIguais {
	String message() default "Os valores são diferentes";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
	String atributo1();
	String atributo2();

	@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@interface List
	{
		AtributosIguais[] value();
	}
}