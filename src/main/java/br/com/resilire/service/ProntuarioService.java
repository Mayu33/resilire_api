/*
 * Interface do Service de Prontuário
 * 
 * Resilire API v1
 * 
 * Autor: Mayara Barranco da Silva
 * Última alteração: 03/06/2021
 * 
 */


package br.com.resilire.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import br.com.resilire.model.Prontuario;

public interface ProntuarioService {

	public Prontuario save(Prontuario prontuario) throws SQLException;
	
	public Optional<Prontuario> findById(Long idProntuario) throws SQLException;
	
	public void deleteById(Long idProntuario) throws SQLException;
	
	public List<Prontuario> list() throws SQLException;
	
	public List<Prontuario> findByIdPaciente(Long idPaciente) throws SQLException;
}
