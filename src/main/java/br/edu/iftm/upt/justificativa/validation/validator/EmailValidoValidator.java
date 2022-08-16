package br.edu.iftm.upt.justificativa.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.validator.routines.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.edu.iftm.upt.justificativa.validation.EmailValido;

public class EmailValidoValidator implements ConstraintValidator<EmailValido, String> {

	private static final Logger logger = LoggerFactory.getLogger(EmailValidoValidator.class);
	
	//Usando commons.validator
	private static final EmailValidator validator = EmailValidator.getInstance();
	//private static final EmailValidator validator = EmailValidator.getInstance(true);
	//private static final EmailValidator validator = EmailValidator.getInstance(true, true);

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		if (email != null && !email.isBlank()) {
			boolean resultado = validator.isValid(email);
			logger.debug("O e-mail {} foi considerado {}", email, resultado?"válido":"inválido");
		return resultado;
		}
		return true;
	}

}