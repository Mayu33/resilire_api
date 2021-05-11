package br.com.resilire.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 


@Entity
public class Paciente {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPaciente;
	private String cpf;
	private Enum sexo;
	private String nome;
	private String sobrenome;
	private String email;
	private String telefone;
	private Long idEndereco;
	
	
	public Paciente(String cpf, Long idPaciente, Enum sexo, String nome, String sobrenome, String email,
			String telefone, Long idEndereco) {
		super();
		this.cpf = cpf;
		this.idPaciente = idPaciente;
		this.sexo = sexo;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.telefone = telefone;
		this.idEndereco = idEndereco;
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
	public Enum getSexo() {
		return sexo;
	}
	public void setSexo(Enum sexo) {
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
	public Long getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}
	
	
	
	
	
}
