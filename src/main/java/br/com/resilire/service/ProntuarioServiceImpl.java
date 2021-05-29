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
	
	@Override
	public Prontuario save(Prontuario prontuario) throws SQLException {
		// TODO Auto-generated method stub
		return repository.save(prontuario);
	}

	@Override
	public Optional<Prontuario> findById(Long idProntuario) throws SQLException {
		// TODO Auto-generated method stub
		return repository.findById(idProntuario);
	}

	@Override
	public void deleteById(Long idProntuario) throws SQLException {
		// TODO Auto-generated method stub
		repository.deleteById(idProntuario);
	}

	@Override
	public List<Prontuario> list() throws SQLException {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public List<Prontuario> findByIdPaciente(Long idPaciente) throws SQLException {
		// TODO Auto-generated method stub
		return repository.findByIdPaciente(idPaciente);
	}

}
