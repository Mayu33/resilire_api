package br.com.resilire.service;

import br.com.resilire.model.Endereco;

public interface EnderecoService {
	
	public Endereco save(Endereco endereco, String cidade, String uf);
	
	public Endereco findById(Long idEndereco);

}
