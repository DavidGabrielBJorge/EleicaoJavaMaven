package br.edu.iftm.upt.justificativa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.iftm.upt.justificativa.model.Cidadao;
import br.edu.iftm.upt.justificativa.model.Situacao;

public interface CidadaoRepository extends JpaRepository<Cidadao, Long> {

	public List<Cidadao>findBySituacaoNot(Situacao situacao);
	
}
