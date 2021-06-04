/*
 * Implementação do Service de Endereco
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


import br.com.resilire.controller.dto.EnderecoDto;
import br.com.resilire.model.Endereco;
import br.com.resilire.repository.EnderecoRepository;



@Service
public class EnderecoServiceImpl implements EnderecoService{

	private final static Logger logger = LoggerFactory.getLogger(EnderecoServiceImpl.class);
	

	@Autowired
	EnderecoRepository enderecoRepository;
	

	// Salva um novo endereço
	@Override
	public Endereco save(Endereco endereco) throws SQLException{
		
		return enderecoRepository.save(endereco);
				
	}
	
	// Lista um endereço pelo ID
	@Override
	public Optional<Endereco> findById(Long idEndereco) throws SQLException{
		return enderecoRepository.findById(idEndereco);
	}
	
	// Deleta um endereco pelo ID
	@Override
	public void deleteById(Long idEndereco) throws SQLException{
		
		enderecoRepository.deleteById(idEndereco);
		
	}
	
	// Lista todos os enderecos
	@Override
	public List<Endereco> list() throws SQLException {
		return enderecoRepository.findAll();
	}

	// Lista todos os enderecos relacionados ao ID do paciente
	@Override
	public List<Endereco> findByIdPaciente(Long idPaciente) throws SQLException {
		// TODO Auto-generated method stub
		return enderecoRepository.findByIdPaciente(idPaciente);
	}
	
	// Lista todos os enderecos relacionados ao ID do psicólogo
	@Override
	public List<Endereco> findByIdPsicologo(Long idPsicologo) throws SQLException {
		// TODO Auto-generated method stub
		return enderecoRepository.findByIdPsicologo(idPsicologo);
	}

	@Override
	public void deleteByIdPsicologo(Long idPsicologo) throws SQLException {
		// TODO Auto-generated method stub
		enderecoRepository.deleteByIdPsicologo(idPsicologo);
	}

	@Override
	public void deleteByIdPaciente(Long idPaciente) throws SQLException {
		// TODO Auto-generated method stub
		enderecoRepository.deleteByIdPaciente(idPaciente);
	}
	
	
	
	
	
}
