package br.com.resilire.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GeneratorType;

@Entity
public class Consulta {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConsulta;
	private Long idPaciente;
	private Long idPsicologo;
	private String dataConsulta;
	private Long idProntuario;
	
	
	public Consulta(Long idPaciente, Long idPsicologo, String dataConsulta, Long idProntuario) {
		super();
		this.idPaciente = idPaciente;
		this.idPsicologo = idPsicologo;
		this.dataConsulta = dataConsulta;
		this.idProntuario = idProntuario;
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
