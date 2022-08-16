package br.edu.iftm.upt.justificativa.repository.helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import br.edu.iftm.upt.justificativa.model.Justificativa;
import br.edu.iftm.upt.justificativa.model.Situacao;

public class JustificativaQueriesImpl implements JustificativaQueries {

	private static final Logger logger = LoggerFactory.getLogger(JustificativaQueriesImpl.class);
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	@Transactional
	public List<Justificativa> buscarComCidadaoEleicao(Situacao situacao) {
		logger.trace("Entrou no método buscarComCidadaoEleicao");
		logger.debug("Situacao recebida como parametro {}", situacao);
		String jpql = "select j from Justificativa j inner join fetch j.cidadao where j.situacao = :situacao";
		TypedQuery<Justificativa> query = manager.createQuery(jpql, Justificativa.class);
		query.setParameter("situacao", situacao);
		List<Justificativa> justificativas = query.getResultList();
		logger.debug("Justificativas buscadas com cidadao");
		for (Justificativa j : justificativas) {
			logger.debug("{}", j);
			logger.debug("cidadao: {}", j.getCidadao());
		}
		jpql = "select j from Justificativa j inner join fetch j.eleicao where j in :justificativas";
		query = manager.createQuery(jpql, Justificativa.class);
		query.setParameter("justificativas", justificativas);
		justificativas = query.getResultList();
		logger.debug("Justificativas buscadas com cidadao e eleicao");
		for (Justificativa j : justificativas) {
			logger.debug("{}", j);
			logger.debug("cidadao: {}", j.getCidadao());
			logger.debug("eleicao: {}", j.getEleicao());
		}
		return justificativas;	
	}

	@Override
	@Transactional
	public Justificativa buscarComCidadaoEleicao(Long codigo) {
		logger.trace("Entrou no método buscarComCidadaoEleicao");
		logger.debug("codigo recebido como parametro {}", codigo);
		String jpql = "select j from Justificativa j inner join fetch j.cidadao where j.codigo = :codigo";
		TypedQuery<Justificativa> query = manager.createQuery(jpql, Justificativa.class);
		query.setParameter("codigo", codigo);
		Justificativa justificativa = query.getSingleResult();
		logger.debug("Justificativa buscada com cidadao");
		logger.debug("{}", justificativa);
		logger.debug("cidadao: {}", justificativa.getCidadao());
		jpql = "select j from Justificativa j inner join fetch j.eleicao where j in :justificativa";
		query = manager.createQuery(jpql, Justificativa.class);
		query.setParameter("justificativa", justificativa);
		justificativa = query.getSingleResult();
		logger.debug("Justificativa buscada com cidadao e eleicao");
		logger.debug("{}", justificativa);
		logger.debug("cidadao: {}", justificativa.getCidadao());
		logger.debug("eleicao: {}", justificativa.getEleicao());
		return justificativa;	
	}

}
