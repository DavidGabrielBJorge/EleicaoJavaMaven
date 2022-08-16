package br.edu.iftm.upt.justificativa.model;

public enum Situacao {
	ABERTO("Aberto"),
	ACEITA("Aceita"),
	NEGADA("Negada"),
	ATIVO("Ativo"),
	INATIVO("Inativo");
	
	private String descricao;
	
	private Situacao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
