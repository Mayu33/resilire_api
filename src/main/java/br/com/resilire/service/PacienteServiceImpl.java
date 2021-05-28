package br.com.resilire.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.resilire.model.Paciente;
import br.com.resilire.repository.PacienteRepository;

@Service
public class PacienteServiceImpl implements PacienteService {

	private final static Logger logger = LoggerFactory.getLogger(PacienteServiceImpl.class);
	
	@Autowired
	PacienteRepository pacienteRepository;
	
	@Override
	public Paciente save(Paciente paciente) throws SQLException {
		// TODO Auto-generated method stub
		return pacienteRepository.save(paciente);
	}

	@Override
	public Optional<Paciente> findById(Long idPaciente) throws SQLException {
		
		return pacienteRepository.findById(idPaciente);
	}

	@Override
	public void deleteById(Long idPaciente) throws SQLException {
		pacienteRepository.deleteById(idPaciente);
		
	}

	@Override
	public List<Paciente> list() throws SQLException {
		
		return pacienteRepository.findAll();
	}

}
