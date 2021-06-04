/*
 * Implementação do Service de Psicologo
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

import br.com.resilire.model.Endereco;
import br.com.resilire.model.Psicologo;
import br.com.resilire.repository.EnderecoRepository;
import br.com.resilire.repository.PsicologoRepository;

@Service
public class PsicologoServiceImpl implements PsicologoService {

	@Autowired
	PsicologoRepository repository;
	
	@Autowired
	EnderecoRepository endRepository;
	
	// Cria um novo psicologo
	@Override
	public Psicologo save(Psicologo psicologo) throws SQLException {
		// TODO Auto-generated method stub
		return repository.save(psicologo);
	}

	// Lista o psicologo por ID
	@Override
	public Optional<Psicologo> findById(Long idPsicologo) throws SQLException {
		// TODO Auto-generated method stub
		return repository.findById(idPsicologo);
	}

	// Deleta um psicólogo e o endereço relacionado ao ID dele
	@Override
	public void deleteById(Long idPsicologo) throws SQLException {
		repository.deleteById(idPsicologo);
		endRepository.deleteByIdPsicologo(idPsicologo);
	}

	@Override
	public List<Psicologo> list() throws SQLException {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
