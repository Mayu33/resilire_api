package br.com.resilire.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import br.com.resilire.model.Consulta;

public interface ConsultaService {

	public Consulta save(Consulta consulta) throws SQLException;
	
	public Optional<Consulta> findById(Long idConsulta) throws SQLException;
	
	public void deleteById(Long idConsulta) throws SQLException;
	
	public List<Consulta> list() throws SQLException;
}
