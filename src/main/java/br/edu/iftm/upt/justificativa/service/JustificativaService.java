package br.edu.iftm.upt.justificativa.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.iftm.upt.justificativa.model.Justificativa;
import br.edu.iftm.upt.justificativa.repository.JustificativaRepository;






@Service
public class JustificativaService {
	private static final Logger logger = LoggerFactory.getLogger(JustificativaService.class);
	
	@Autowired
	private JustificativaRepository justificativaRepository;
	
	@Transactional
	//abre e fecha a transacao quando o metodo eh chamado
	public Justificativa salvar(Justificativa justificativa) {
		logger.trace("Entrou no metodo salvar");
		logger.info("Lote recebido: {}", justificativa);
		return justificativaRepository.save(justificativa);
	}

	@Transactional
	public Justificativa alterar(Justificativa justificativa) {
		logger.trace("Entrou no metodo alterar");
		logger.info("Lote recebido: {}", justificativa);
		return justificativaRepository.save(justificativa);
	}
	
	
}
