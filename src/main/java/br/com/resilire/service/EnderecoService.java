package br.com.resilire.service;


import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import br.com.resilire.controller.dto.EnderecoDto;
import br.com.resilire.model.Endereco;


public interface EnderecoService {
	
	public Endereco save(Endereco endereco) throws SQLException;
	
	public Optional<Endereco> findById(Long idEndereco) throws SQLException;
	
	public void deleteById(Long idEndereco) throws SQLException;
	
	public List<Endereco> list() throws SQLException;

	

}
