package br.edu.iftm.upt.justificativa.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.edu.iftm.upt.justificativa.validation.validator.RelacionalIntValidator;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RelacionalIntValidator.class)
@Documented
public @interface RelacionalInt {

	String atributo1();
	String atributo2();
	Relacao relacao();

	String message() default "";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@interface List {
		RelacionalInt[] valor();
	}

	public enum Relacao {
		IGUAL,
		DIFERENTE,
		MAIOR,
		MENOR,
		MAIORIGUAL,
		MENORIGUAL
	}
	
}