/*
 * Implementação do Service de Consulta
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

import br.com.resilire.model.Consulta;
import br.com.resilire.repository.ConsultaRepository;

@Service
public class ConsultaServiceImpl implements ConsultaService {

	
	@Autowired
	ConsultaRepository repository;
	
	// Salva uma nova consulta
	@Override
	public Consulta save(Consulta consulta) throws SQLException {
		return repository.save(consulta);
	}

	// Lista uma consulta por ID
	@Override
	public Optional<Consulta> findById(Long idConsulta) throws SQLException {
		return repository.findById(idConsulta);
	}

	// Deleta uma consulta por ID
	@Override
	public void deleteById(Long idConsulta) throws SQLException {
		repository.deleteById(idConsulta);
	}

	// Lista todas as consultas
	@Override
	public List<Consulta> list() throws SQLException {
		return repository.findAll();
	}

	// Lista consultas pelo ID do Paciente
	@Override
	public List<Consulta> findByIdPaciente(Long idPaciente) throws SQLException {
		// TODO Auto-generated method stub
		return repository.findByIdPaciente(idPaciente);
	}

	// Lista consultas pelo ID do Psicologo
	@Override
	public List<Consulta> findByIdPsicologo(Long idPsicologo) throws SQLException {
		// TODO Auto-generated method stub
		return repository.findByIdPsicologo(idPsicologo);
	}

	// Lista consultas pelo status
	@Override
	public List<Consulta> findByStatus(String status) throws SQLException {
		// TODO Auto-generated method stub
		return repository.findByStatus(status);
	}
	
	

}
