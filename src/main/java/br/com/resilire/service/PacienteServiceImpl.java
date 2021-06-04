/*
 * Interface do Service de Consulta
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.resilire.model.Paciente;
import br.com.resilire.repository.EnderecoRepository;
import br.com.resilire.repository.PacienteRepository;

@Service
public class PacienteServiceImpl implements PacienteService {

	private final static Logger logger = LoggerFactory.getLogger(PacienteServiceImpl.class);
	
	@Autowired
	PacienteRepository pacienteRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	// Salva um novo paciente
	@Override
	public Paciente save(Paciente paciente) throws SQLException {
		// TODO Auto-generated method stub
		return pacienteRepository.save(paciente);
		
	}

	// Lista o paciente pelo ID
	@Override
	public Optional<Paciente> findById(Long idPaciente) throws SQLException {
		
		return pacienteRepository.findById(idPaciente);
		
	}
	
	
	// Deleta o paciente e endereços relacionados ao paciente pelo ID
	@Override
	public void deleteById(Long idPaciente) throws SQLException {
		
		if(idPaciente != null ) {
			enderecoRepository.deleteByIdPaciente(idPaciente);
			pacienteRepository.deleteById(idPaciente);
		}
		
	}

	// Lista todos os pacientes
	@Override
	public List<Paciente> list() throws SQLException {
		
		return pacienteRepository.findAll();
	}

}
