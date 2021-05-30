package br.com.resilire.controller.dto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.resilire.model.Paciente;

public class PacienteDto {

	private Long idPaciente;
	private String cpf;
	private String sexo;
	private String nome;
	private String sobrenome;
	private String email;
	private String telefone;
	
	
	public PacienteDto(Paciente paciente) {
		super();
		this.idPaciente = paciente.getIdPaciente();
		this.cpf = paciente.getCpf();
		this.sexo = paciente.getSexo();
		this.nome = paciente.getNome();
		this.sobrenome = paciente.getSobrenome();
		this.email = paciente.getEmail();
		this.telefone = paciente.getTelefone();
	}
	
	public Long getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
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

	public static List<PacienteDto> converterList(List<Paciente> pacientes){
		return pacientes.stream().map(PacienteDto::new).collect(Collectors.toList());
	}
	
	public static List<PacienteDto> converterOptional(Optional<Paciente> pacientes) {
		return pacientes.stream().map(PacienteDto::new).collect(Collectors.toList());
	}
	
	
	
}
