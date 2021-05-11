package br.com.resilire.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Psicologo {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPsicologo;
	private String crp;
	private String nome;
	private String sobrenome;
	private String email;
	private String telefone;
	private Long idEndereco;
	private Long idEspecialidade;
	

	public Psicologo() {
		super();
	}

	public Psicologo(String crp, String nome, String sobrenome, String email, String telefone, Long idEndereco,
			Long idEspecialidade) {
		super();
		this.crp = crp;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.telefone = telefone;
		this.idEndereco = idEndereco;
		this.idEspecialidade = idEspecialidade;
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
	public Long getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}
	public Long getIdEspecialidade() {
		return idEspecialidade;
	}
	public void setIdEspecialidade(Long idEspecialidade) {
		this.idEspecialidade = idEspecialidade;
	}
	
	
	

}
