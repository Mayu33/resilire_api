package br.com.resilire.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Especialidade {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEspecialidade;
	private String nome;
	
	public Especialidade(String nome) {
		super();
		this.nome = nome;
	}

	public Especialidade() {
		super();
	}
	
	public Long getIdEspecialidade() {
		return idEspecialidade;
	}
	public void setIdEspecialidade(Long idEspecialidade) {
		this.idEspecialidade = idEspecialidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
