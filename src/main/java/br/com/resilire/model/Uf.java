package br.com.resilire.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Uf {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUf;
	private String nome;
	
	public Uf() {
		super();
	}
	
	public Uf(String nome) {
		super();
		this.nome = nome;
	}
	
	public Long getIdUf() {
		return idUf;
	}
	public void setIdUf(Long idUf) {
		this.idUf = idUf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
