/*
 * RESILIRE API
 * 
 * API REST de Pacientes, Psicólogos, Endereços, Consultas e Prontuários
 * v1 - 03/06/2021
 * 
 * Autora: Mayara Barranco da Silva
 * 
 * Projeto para a Disciplina de Hands on Work
 * 
 * Universidade do Vale do Itajaí UNIVALI
 * Escola do Mar, Ciência e Tecnologia
 * Tecnólogo em Análise e Desenvolvimento de Sistemas
 * Disciplina: Hands on Work VI
 * Orientador: Profº. MSc. Lucas Debatin
 * 
 * Alunos:
 * 		Laudiane de Oliveira do Espirito Santo
 * 		Mayara Barranco da Silva
 * 		Rondinele Sousa Guimarães
 * 		Tamyris Roncelli
 * 
 */

package br.com.resilire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;


@SpringBootApplication
@EnableSpringDataWebSupport
public class ResilireApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResilireApplication.class, args);
	}

}
