package br.edu.iftm.upt.justificativa.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;

//import br.edu.iftm.upt.justificativa.repository.ContatoRepository;
import br.edu.iftm.upt.justificativa.validation.EmailUnico;

public class EmailUnicoValidator implements ConstraintValidator<EmailUnico, String> {

//	private static final Logger logger = LoggerFactory.getLogger(EmailUnicoValidator.class);
	
//	@Autowired
//	private ContatoRepository repository;

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
//		if (email != null && !email.isBlank()) {
//			long quantos = repository.countByEmailContainingIgnoreCase(email);
//			logger.debug("Email {} aparece no BD {} vezes", email, quantos);
//			return quantos == 0;
//		} else {
//			return true;
//		}
		return true;  //ARRUMAR
	}

}