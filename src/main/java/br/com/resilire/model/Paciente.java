package br.com.resilire.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table; 


@Entity
@Table(name="Paciente")
public class Paciente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name="idPaciente")
	private Long idPaciente;
	@Column(name="cpf")
	private String cpf;
	@Column(name="sexo")
	private String sexo;
	@Column(name="nome")
	private String nome;
	@Column(name="sobrenome")
	private String sobrenome;
	@Column(name="email")
	private String email;
	@Column(name="telefone")
	private String telefone;
	
	
	public Paciente() {
		super();
	}


	public Paciente(String cpf, Long idPaciente, String sexo, String nome, String sobrenome, String email,
			String telefone) {
		super();
		this.cpf = cpf;
		this.idPaciente = idPaciente;
		this.sexo = sexo;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.telefone = telefone;
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

	
	
	
	
	
}
