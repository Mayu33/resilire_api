package br.com.resilire.controller.dto;

import java.util.Optional;

import org.springframework.data.domain.Page;

import br.com.resilire.model.Endereco;

public class EnderecoDto {

	private Long idEndereco;
	private String cep;
	private String rua;
	private String numero;
	private String complemento;
	private String bairro;
	private Long idCidade;
	private Long idUf;
	
	
	public EnderecoDto(Endereco endereco) {
		this.idEndereco = endereco.getIdEndereco();
		this.cep = endereco.getCep();
		this.rua = endereco.getRua();
		this.numero = endereco.getNumero();
		this.complemento = endereco.getComplemento();
		this.bairro = endereco.getBairro();
		this.idCidade = endereco.getIdCidade();
		this.idUf = endereco.getIdUf();
		
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
	public Long getIdCidade() {
		return idCidade;
	}
	public void setIdCidade(Long idCidade) {
		this.idCidade = idCidade;
	}
	public Long getIdUf() {
		return idUf;
	}
	public void setIdUf(Long idUf) {
		this.idUf = idUf;
	}
	
	public static Page<EnderecoDto> converterPage(Page<Endereco> enderecos) {
		return enderecos.map(EnderecoDto::new);
	}
	
	public static Optional<EnderecoDto> converterOptional(Optional<Endereco> enderecos) {
		return enderecos.map(EnderecoDto::new);
	}
	
}
