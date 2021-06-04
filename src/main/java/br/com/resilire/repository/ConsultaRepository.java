/*
 * Interface de Consulta
 * A interface JpaRepository já implementa as funções de CRUD básicas,
 * adicionamos três métodos de listagem personalizados de acordo com 
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

import br.com.resilire.model.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long>{

	public List<Consulta> findByIdPaciente(Long idPaciente);
	
	public List<Consulta> findByIdPsicologo(Long idPsicologo);
	
	public List<Consulta> findByStatus(String status);
}
