package br.edu.iftm.upt.justificativa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.iftm.upt.justificativa.model.Eleicao;
import br.edu.iftm.upt.justificativa.model.Situacao;

public interface EleicaoRepository extends JpaRepository<Eleicao, Long> {

	public List<Eleicao>findBySituacaoNot(Situacao situacao);
	
}
