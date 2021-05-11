package br.com.resilire.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.resilire.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{
	
	public Cidade findByNome(String nome);

}
