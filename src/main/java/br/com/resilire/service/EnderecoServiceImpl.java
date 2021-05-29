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
	

	@Override
	public Endereco save(Endereco endereco) throws SQLException{
		
		return enderecoRepository.save(endereco);
				
	}
	
	
	@Override
	public Optional<Endereco> findById(Long idEndereco) throws SQLException{
		return enderecoRepository.findById(idEndereco);
	}
	
	@Override
	public void deleteById(Long idEndereco) throws SQLException{
		
		enderecoRepository.deleteById(idEndereco);
		
	}
	
	@Override
	public List<Endereco> list() throws SQLException {
		return enderecoRepository.findAll();
	}


	@Override
	public List<Endereco> findByIdUser(Long idUser) throws SQLException {
		// TODO Auto-generated method stub
		return enderecoRepository.findByIdUser(idUser);
	}
	
	
}
