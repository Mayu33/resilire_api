package br.com.resilire.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Endereco")
public class Endereco implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name="idEndereco")
	private Long idEndereco;
	// idUser se refere ao paciente ou psicólogo que é dono do endereço
	@Column(name="idPaciente")
	private Long idPaciente;
	@Column(name="idPsicologo")
	private Long idPsicologo;
	@Column(name="cep")	
	private String cep;
	@Column(name="apelido")
	private String apelido;
	@Column(name="rua")
	private String rua;
	@Column(name="numero")
	private String numero;
	@Column(name="complemento")
	private String complemento;
	@Column(name="bairro")
	private String bairro;
	@Column(name="cidade")
	private String cidade;
	@Column(name="uf")
	private String uf;
	
	

	public Endereco() {
		super();
	}

	

	public Endereco(Long idPaciente, Long idPsicologo, String apelido, String cep, String rua, String numero, String complemento, String bairro, String cidade, String uf) {
		super();
		this.idPaciente = idPaciente;
		this.idPsicologo = idPsicologo;
		this.apelido = apelido;
		this.cep = cep;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
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
	public Long getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}



	public String getCidade() {
		return cidade;
	}



	public void setCidade(String cidade) {
		this.cidade = cidade;
	}



	public String getUf() {
		return uf;
	}



	public void setUf(String uf) {
		this.uf = uf;
	}



	public String getApelido() {
		return apelido;
	}



	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	
	
	
	


	
	
	
}
