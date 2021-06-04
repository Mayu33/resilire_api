/*
 * DTO da classe Consulta
 * Resilire API v1
 * 
 * Autor: Mayara Barranco da Silva
 * Última alteração: 03/06/2021
 * 
 */

package br.com.resilire.controller.dto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.resilire.model.Consulta;

public class ConsultaDto {

	private Long idConsulta;
	private Long idPaciente;
	private Long idPsicologo;
	private String dataConsulta;
	private String status;
	private Long idProntuario;
	
	
	public ConsultaDto(Consulta consulta) {
		super();
		this.idConsulta = consulta.getIdConsulta();
		this.idPaciente = consulta.getIdPaciente();
		this.idPsicologo = consulta.getIdPsicologo();
		this.dataConsulta = consulta.getDataConsulta();
		this.status = consulta.getStatus();
		this.idProntuario = consulta.getIdProntuario();
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
	
	public static List<ConsultaDto> converterList(List<Consulta> consultas){
		return consultas.stream().map(ConsultaDto::new).collect(Collectors.toList());
	}
	
	public static List<ConsultaDto> converterOptional(Optional<Consulta> consultas) {
		return consultas.stream().map(ConsultaDto::new).collect(Collectors.toList());
	}
	
	
	
}
