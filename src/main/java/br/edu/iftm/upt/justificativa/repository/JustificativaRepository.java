package br.edu.iftm.upt.justificativa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.iftm.upt.justificativa.model.Justificativa;
import br.edu.iftm.upt.justificativa.repository.helper.JustificativaQueries;

public interface JustificativaRepository  extends JpaRepository<Justificativa, Long>, JustificativaQueries {

}
