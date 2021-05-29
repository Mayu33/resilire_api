package br.com.resilire.controller.dto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.resilire.model.Prontuario;

public class ProntuarioDto {

	private Long idProntuario;
	private Long idPaciente;
	private String observacao;
	private String prescricao;
	
	
	
	public ProntuarioDto(Prontuario prontuario) {
		super();
		this.idProntuario = prontuario.getIdProntuario();
		this.idPaciente = prontuario.getIdPaciente();
		this.observacao = prontuario.getObservacao();
		this.prescricao = prontuario.getPrescricao();
	}
	public Long getIdProntuario() {
		return idProntuario;
	}
	public void setIdProntuario(Long idProntuario) {
		this.idProntuario = idProntuario;
	}
	public Long getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public String getPrescricao() {
		return prescricao;
	}
	public void setPrescricao(String prescricao) {
		this.prescricao = prescricao;
	}
	
	public static List<ProntuarioDto> converterList(List<Prontuario> prontuarios){
		return prontuarios.stream().map(ProntuarioDto::new).collect(Collectors.toList());
	}
	
	public static List<ProntuarioDto> converterOptional(Optional<Prontuario> prontuarios) {
		return prontuarios.stream().map(ProntuarioDto::new).collect(Collectors.toList());
	}
	
	
}
