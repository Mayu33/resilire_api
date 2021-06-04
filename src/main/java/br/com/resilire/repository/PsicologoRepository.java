/*
 * Interface de Psicologo
 * A interface JpaRepository já implementa as funções de CRUD básicas
 * 
 * Resilire API v1
 * 
 * Autor: Mayara Barranco da Silva
 * Última alteração: 03/06/2021
 * 
 */

package br.com.resilire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.resilire.model.Psicologo;

@Repository
public interface PsicologoRepository extends JpaRepository<Psicologo, Long>{

}
