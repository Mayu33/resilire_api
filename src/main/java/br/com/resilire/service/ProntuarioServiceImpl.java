package br.com.resilire.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.resilire.model.Prontuario;

@Service
public class ProntuarioServiceImpl implements ProntuarioService{

	@Override
	public Prontuario save(Prontuario prontuario) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Prontuario> findById(Long idProntuario) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long idProntuario) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Prontuario> list() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
