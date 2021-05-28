package br.com.resilire.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.resilire.model.Psicologo;
import br.com.resilire.repository.PsicologoRepository;

@Service
public class PsicologoServiceImpl implements PsicologoService {

	@Autowired
	PsicologoRepository repository;
	
	@Override
	public Psicologo save(Psicologo psicologo) throws SQLException {
		// TODO Auto-generated method stub
		return repository.save(psicologo);
	}

	@Override
	public Optional<Psicologo> findById(Long idPsicologo) throws SQLException {
		// TODO Auto-generated method stub
		return repository.findById(idPsicologo);
	}

	@Override
	public void deleteById(Long idPsicologo) throws SQLException {
		repository.deleteById(idPsicologo);
		
	}

	@Override
	public List<Psicologo> list() throws SQLException {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
