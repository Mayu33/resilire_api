package br.com.resilire.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.resilire.model.Uf;


public interface UfRepository extends JpaRepository<Uf, Long>{

	
	public Uf findByNome(String nome);
}
