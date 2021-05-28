package br.com.resilire.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import br.com.resilire.model.Paciente;

public interface PacienteService {

	public Paciente save(Paciente paciente) throws SQLException;
	
	public Optional<Paciente> findById(Long idPaciente) throws SQLException;
	
	public void deleteById(Long idPaciente) throws SQLException;
	
	public List<Paciente> list() throws SQLException;
	
}
