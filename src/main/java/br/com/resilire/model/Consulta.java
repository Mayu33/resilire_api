/*
 * Model do objeto Consulta
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
@Table(name="Consulta")
public class Consulta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConsulta;
	private Long idPaciente;
	private Long idPsicologo;
	private String dataConsulta;
	private String status;
	private Long idProntuario;
	
	
	
	
	public Consulta() {
		super();
	}


	public Consulta(Long idPaciente, Long idPsicologo, String dataConsulta, String status, Long idProntuario) {
		super();
		this.idPaciente = idPaciente;
		this.idPsicologo = idPsicologo;
		this.dataConsulta = dataConsulta;
		this.status = status;
		this.idProntuario = idProntuario;
	}


	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getIdConsulta() {
		return idConsulta;
	}
	public void setIdConsulta(Long idConsulta) {
		this.idConsulta = idConsulta;
	}


	public Long getIdPaciente() {
		return idPaciente;
	}


	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}


	public Long getIdPsicologo() {
		return idPsicologo;
	}


	public void setIdPsicologo(Long idPsicologo) {
		this.idPsicologo = idPsicologo;
	}


	public String getDataConsulta() {
		return dataConsulta;
	}


	public void setDataConsulta(String dataConsulta) {
		this.dataConsulta = dataConsulta;
	}


	public Long getIdProntuario() {
		return idProntuario;
	}


	public void setIdProntuario(Long idProntuario) {
		this.idProntuario = idProntuario;
	}

	
	
}
