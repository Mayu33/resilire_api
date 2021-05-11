package br.com.resilire.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.sun.el.stream.Optional;

import br.com.resilire.controller.dto.EnderecoDto;
import br.com.resilire.model.Cidade;
import br.com.resilire.model.Endereco;
import br.com.resilire.model.Uf;
import br.com.resilire.repository.CidadeRepository;
import br.com.resilire.repository.EnderecoRepository;
import br.com.resilire.repository.UfRepository;
import br.com.resilire.service.EnderecoService;

@Service
public class EnderecoServiceImpl {

	
	@Autowired
	UfRepository ufRepository;
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	

	
	public Endereco save(Endereco endereco, String cidadeNome, String ufNome) {
		
		
		Long idUf = validaESalvaUf(ufNome);
		Long idCidade = validaESalvaCidade(cidadeNome, idUf);
		
		endereco.setIdCidade(idCidade);
		endereco.setIdUf(idUf);
				
		return endereco;
	}
	
	public Long validaESalvaUf(String ufNome) {
		
		Uf uf = ufRepository.findByNome(ufNome);
		
		if(uf.getIdUf() == null) {
		Uf newUf = new Uf(ufNome);
		return newUf.getIdUf();
		} else {
			uf = ufRepository.findByNome(ufNome);
			return uf.getIdUf();
		}		
	}
	
	public Long validaESalvaCidade(String cidadeNome, Long idUf) {
		
		Cidade cidade = cidadeRepository.findByNome(cidadeNome);
		
		if(cidade.getIdCidade() == null) {
			Cidade newCidade = new Cidade(cidadeNome, idUf);
			return newCidade.getIdCidade();
		} else {
			cidade = cidadeRepository.findByNome(cidadeNome);
			return cidade.getIdCidade();
		}		
	}

	


	
	
	
	
	
}
