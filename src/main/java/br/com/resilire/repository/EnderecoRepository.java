/*
 * Interface de Endereco
 * A interface JpaRepository já implementa as funções de CRUD básicas,
 * adicionamos dois métodos de listagem personalizados de acordo com 
 * a necessidade.
 * 
 * Resilire API v1
 * 
 * Autor: Mayara Barranco da Silva
 * Última alteração: 03/06/2021
 * 
 */
package br.com.resilire.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.resilire.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

	// Criando os métodos no repository, o Springboot gera a query automaticamente
	
	public List<Endereco> findByIdPaciente(Long idPaciente);
	
	public List<Endereco> findByIdPsicologo(Long idPsicologo);
	
	public void deleteByIdPaciente(Long idPaciente);
	
	public void deleteByIdPsicologo(Long idPsicologo);
	
}
