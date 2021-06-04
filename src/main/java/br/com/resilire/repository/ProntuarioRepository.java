/*
 * Interface de Prontuario
 * A interface JpaRepository já implementa as funções de CRUD básicas,
 * adicionamos um método de listagem personalizado de acordo com 
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

import br.com.resilire.model.Prontuario;

@Repository
public interface ProntuarioRepository extends JpaRepository<Prontuario, Long>{

	public List<Prontuario> findByIdPaciente(Long idPaciente);
}
