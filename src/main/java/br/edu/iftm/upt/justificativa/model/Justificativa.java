package br.edu.iftm.upt.justificativa.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@Table(name = "justificativa")
public class Justificativa implements Serializable {

	private static final long serialVersionUID = -1995762289777693275L;
	
	@Id
	@SequenceGenerator(name = "gerador", sequenceName = "justificativa_codigo_seq", allocationSize = 1)
	@GeneratedValue(generator = "gerador", strategy = GenerationType.SEQUENCE)
	private Long codigo;
	private String conteudo;
	private LocalDate data;
	private LocalTime hora;
	@Enumerated(EnumType.STRING)
	private Situacao situacao;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_cidadao")
	private Cidadao cidadao;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_eleicao")
	private Eleicao eleicao;
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "codigo_juiz")
	private Juiz juiz;

	public Justificativa() {
		data = LocalDate.now();
		hora = LocalTime.now();
		situacao = Situacao.ABERTO;
	}
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public Cidadao getCidadao() {
		return cidadao;
	}

	public void setCidadao(Cidadao cidadao) {
		this.cidadao = cidadao;
	}

	public Eleicao getEleicao() {
		return eleicao;
	}

	public void setEleicao(Eleicao eleicao) {
		this.eleicao = eleicao;
	}

	public Juiz getJuiz() {
		return juiz;
	}

	public void setJuiz(Juiz juiz) {
		this.juiz = juiz;
	}

	@Override
	public String toString() {
		return "codigo: " + codigo + "\nconteudo: " + conteudo + "\ndata: " + data + "\nhora: " + hora + "\nsituacao: "
				+ situacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Justificativa other = (Justificativa) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}
