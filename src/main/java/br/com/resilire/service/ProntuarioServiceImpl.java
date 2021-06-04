/*
 * Implementação do Service de Prontuario
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.resilire.model.Prontuario;
import br.com.resilire.repository.ProntuarioRepository;

@Service
public class ProntuarioServiceImpl implements ProntuarioService{

	@Autowired
	ProntuarioRepository repository;
	
	// Salva um novo prontuário
	@Override
	public Prontuario save(Prontuario prontuario) throws SQLException {
		// TODO Auto-generated method stub
		return repository.save(prontuario);
	}

	// Lista o prontuário por ID
	@Override
	public Optional<Prontuario> findById(Long idProntuario) throws SQLException {
		// TODO Auto-generated method stub
		return repository.findById(idProntuario);
	}

	// Deleta um prontuário por ID
	@Override
	public void deleteById(Long idProntuario) throws SQLException {
		// TODO Auto-generated method stub
		repository.deleteById(idProntuario);
	}

	// Lista todos os prontuários
	@Override
	public List<Prontuario> list() throws SQLException {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	// Lista os prontuários relacionados ao ID do paciente
	@Override
	public List<Prontuario> findByIdPaciente(Long idPaciente) throws SQLException {
		// TODO Auto-generated method stub
		return repository.findByIdPaciente(idPaciente);
	}

}
