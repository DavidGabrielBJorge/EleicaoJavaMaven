package br.edu.iftm.upt.justificativa.repository.helper;

import java.util.List;

import br.edu.iftm.upt.justificativa.model.Justificativa;
import br.edu.iftm.upt.justificativa.model.Situacao;

public interface JustificativaQueries {

	public List<Justificativa> buscarComCidadaoEleicao(Situacao situacao);
	public Justificativa buscarComCidadaoEleicao(Long codigo);
	
}
