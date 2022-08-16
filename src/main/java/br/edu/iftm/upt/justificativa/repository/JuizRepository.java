package br.edu.iftm.upt.justificativa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.iftm.upt.justificativa.model.Juiz;
import br.edu.iftm.upt.justificativa.model.Situacao;

public interface JuizRepository  extends JpaRepository<Juiz, Long> {

	public List<Juiz>findBySituacaoNot(Situacao situacao); 
	
}	