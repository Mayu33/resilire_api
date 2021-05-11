package br.com.resilire.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cidade {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCidade;
	private String nome;
	private Long idUf;
	
	public Cidade(String nome, Long idUf) {
		super();
		this.nome = nome;
		this.idUf = idUf;
	}
	
	public Cidade() {
		super();
	}

	public Long getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(Long idCidade) {
		this.idCidade = idCidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getIdUf() {
		return idUf;
	}

	public void setIdUf(Long idUf) {
		this.idUf = idUf;
	}

	
	
	
	
}
