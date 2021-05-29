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
	
	@Override
	public Consulta save(Consulta consulta) throws SQLException {
		// TODO Auto-generated method stub
		return repository.save(consulta);
	}

	@Override
	public Optional<Consulta> findById(Long idConsulta) throws SQLException {
		// TODO Auto-generated method stub
		return repository.findById(idConsulta);
	}

	@Override
	public void deleteById(Long idConsulta) throws SQLException {
		// TODO Auto-generated method stub
		repository.deleteById(idConsulta);
	}

	@Override
	public List<Consulta> list() throws SQLException {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public List<Consulta> findByIdPaciente(Long idPaciente) throws SQLException {
		// TODO Auto-generated method stub
		return repository.findByIdPaciente(idPaciente);
	}

	@Override
	public List<Consulta> findByIdPsicologo(Long idPsicologo) throws SQLException {
		// TODO Auto-generated method stub
		return repository.findByIdPsicologo(idPsicologo);
	}

}
