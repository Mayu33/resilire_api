package br.com.resilire.controller.dto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.resilire.model.Psicologo;

public class PsicologoDto {

	private Long idPsicologo;
	private String crp;
	private String nome;
	private String sobrenome;
	private String email;
	private String telefone;
	private String especialidade;
	
	
	public PsicologoDto() {
		super();
	}


	public PsicologoDto(Psicologo p) {
		super();
		this.idPsicologo = p.getIdPsicologo();
		this.crp = p.getCrp();
		this.nome = p.getNome();
		this.sobrenome = p.getSobrenome();
		this.email = p.getEmail();
		this.telefone = p.getTelefone();
		this.especialidade = p.getEspecialidade();
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
	
	public static List<PsicologoDto> converterList(List<Psicologo> psicologos){
		return psicologos.stream().map(PsicologoDto::new).collect(Collectors.toList());
	}
	
	public static List<PsicologoDto> converterOptional(Optional<Psicologo> psicologos) {
		return psicologos.stream().map(PsicologoDto::new).collect(Collectors.toList());
	}
	
	
	
}
