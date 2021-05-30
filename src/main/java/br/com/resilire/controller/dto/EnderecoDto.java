package br.com.resilire.controller.dto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import br.com.resilire.model.Endereco;

public class EnderecoDto {

	private Long idEndereco;
	private Long idPsicologo;
	private Long idPaciente;
	private String apelido;
	private String cep;
	private String rua;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	
	

	public EnderecoDto(Endereco endereco) {
		this.idEndereco = endereco.getIdEndereco();
		this.idPsicologo = endereco.getIdPsicologo();
		this.idPaciente = endereco.getIdPaciente();
		this.apelido = endereco.getApelido();
		this.cep = endereco.getCep();
		this.rua = endereco.getRua();
		this.numero = endereco.getNumero();
		this.complemento = endereco.getComplemento();
		this.bairro = endereco.getBairro();
		this.cidade = endereco.getCidade();
		this.uf = endereco.getUf();
	}
	
	
	
	public Long getIdPsicologo() {
		return idPsicologo;
	}
	public void setIdPsicologo(Long idPsicologo) {
		this.idPsicologo = idPsicologo;
	}
	public Long getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
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


	public static List<EnderecoDto> converterList(List<Endereco> enderecos) {
		return enderecos.stream().map(EnderecoDto::new).collect(Collectors.toList());
	}
	
	public static List<EnderecoDto> converterOptional(Optional<Endereco> enderecos) {
		return enderecos.stream().map(EnderecoDto::new).collect(Collectors.toList());
	}
	
}
