/*
 * Model do objeto Prontuario
 * Resilire API v1
 * 
 * Autor: Mayara Barranco da Silva
 * Última alteração: 03/06/2021
 * 
 */
package br.com.resilire.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Prontuario")
public class Prontuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProntuario;
	private Long idPaciente;
	private String observacao;
	private String prescricao;
	
	
	public Prontuario() {
		super();
	}

	public Prontuario(Long idPaciente, String observacao, String prescricao) {
		super();
		this.idPaciente = idPaciente;
		this.observacao = observacao;
		this.prescricao = prescricao;
	}
	
	public Long getIdProntuario() {
		return idProntuario;
	}
	public void setIdProntuario(Long idProntuario) {
		this.idProntuario = idProntuario;
	}
	public Long getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public String getPrescricao() {
		return prescricao;
	}
	public void setPrescricao(String prescricao) {
		this.prescricao = prescricao;
	}
	
	
	
}
