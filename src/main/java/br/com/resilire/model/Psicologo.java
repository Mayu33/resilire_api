/*
 * Model do objeto Psicologo
 * Resilire API v1
 * 
 * Autor: Mayara Barranco da Silva
 * Última alteração: 03/06/2021
 * 
 */

package br.com.resilire.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Psicologo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name="idPsicologo")
	private Long idPsicologo;
	@Column(name="crp")
	private String crp;
	@Column(name="nome")
	private String nome;
	@Column(name="sobrenome")
	private String sobrenome;
	@Column(name="email")
	private String email;
	@Column(name="telefone")
	private String telefone;
	@Column(name="especialidade")
	private String especialidade;
	

	public Psicologo() {
		super();
	}

	public Psicologo(String crp, String nome, String sobrenome, String email, String telefone, 
			String especialidade) {
		super();
		this.crp = crp;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.telefone = telefone;
		this.especialidade = especialidade;
	}
	
	public Long getIdPsicologo() {
		return idPsicologo;
	}
	public void setIdPsicologo(Long idPsicologo) {
		this.idPsicologo = idPsicologo;
	}
	public String getCrp() {
		return crp;
	}
	public void setCrp(String crp) {
		this.crp = crp;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	
	
	

}
