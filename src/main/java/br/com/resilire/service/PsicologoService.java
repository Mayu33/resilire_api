package br.com.resilire.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


import br.com.resilire.model.Psicologo;

public interface PsicologoService {

	public Psicologo save(Psicologo psicologo) throws SQLException;
	
	public Optional<Psicologo> findById(Long idPsicologo) throws SQLException;
	
	public void deleteById(Long idPsicologo) throws SQLException;
	
	public List<Psicologo> list() throws SQLException;
}
