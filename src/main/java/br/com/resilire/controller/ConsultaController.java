/*
 * Controller do CRUD de Consultas
 * Resilire API v1
 * 
 * Autor: Mayara Barranco da Silva
 * Última alteração: 03/06/2021
 * 
 */

package br.com.resilire.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.resilire.controller.dto.ConsultaDto;
import br.com.resilire.model.Consulta;
import br.com.resilire.service.ConsultaService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/consulta")
@Api(value="API REST Consultas")
@CrossOrigin(origins="*")
public class ConsultaController {
	
	private final static Logger logger = LoggerFactory.getLogger(ConsultaController.class);

	@Autowired
	ConsultaService service;
	
	// Retorna lista de consultas por ID
	@GetMapping("/{idConsulta}")
	public ResponseEntity<List<ConsultaDto>> findById(@PathVariable("idConsulta") Long id, Model model) {

		try {
			List<ConsultaDto> dto = ConsultaDto.converterOptional(service.findById(id));
			logger.debug("Request Consulta por ID");
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} catch (SQLException e) {
			logger.debug("Problema ao acessar a lista de consultas");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	// Retorna lista de consultas por status
	@GetMapping("/{status}")
	public ResponseEntity<List<ConsultaDto>> findByStatus(@RequestParam(value="status") String status, Model model) {

		try {
			List<ConsultaDto> dto = ConsultaDto.converterList(service.findByStatus(status));
			logger.debug("Request Consulta por Status");
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} catch (SQLException e) {
			logger.debug("Problema ao acessar a lista de consultas por status");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	// Retorna lista de consultas por paciente
	@GetMapping("/paciente/{idPaciente}")
	public ResponseEntity<List<ConsultaDto>> findByIdPaciente(@PathVariable("idPaciente") Long id, Model model) {

		try {
			List<ConsultaDto> dto = ConsultaDto.converterList(service.findByIdPaciente(id));
			logger.debug("Request Consulta por ID do Paciente");
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} catch (SQLException e) {
			logger.debug("Problema ao acessar a lista de consultas");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	// Retorna lista de consultas por psicologo
	@GetMapping("/psicologo/{idPsicologo}")
	public ResponseEntity<List<ConsultaDto>> findByIdPsicologo(@PathVariable("idPsicologo") Long id, Model model) {

		try {
			List<ConsultaDto> dto = ConsultaDto.converterList(service.findByIdPsicologo(id));
			logger.debug("Request Consulta por ID do Psicologo");
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} catch (SQLException e) {
			logger.debug("Problema ao acessar a lista de consultas");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	// Atualiza uma consulta pelo ID
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ConsultaDto> atualizar(@PathVariable Long id, @RequestBody @Validated Consulta c) throws SQLException {

		Optional<Consulta> edit = service.findById(id);
		if(edit.isPresent()) {
			Consulta con = edit.get();
			con.setIdConsulta(c.getIdConsulta());
			con.setIdPaciente(c.getIdPaciente());
			con.setIdPsicologo(c.getIdPsicologo());
			con.setIdProntuario(c.getIdProntuario());
			con.setStatus(c.getStatus());
			con.setDataConsulta(c.getDataConsulta());
			service.save(con);
			logger.debug("Consulta atualizada com sucesso");
			return new ResponseEntity<>(new ConsultaDto(con), HttpStatus.OK);
		} else {
			logger.debug("Erro ao atualizar consulta");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		
		
		
	}

	// Cadastra uma nova consulta
	@PostMapping("/")
	@Transactional
	public ResponseEntity<ConsultaDto> cadastrar(@RequestBody @Validated Consulta consulta) {

		try {
			
			ConsultaDto dto = new ConsultaDto(service.save(consulta));
			logger.debug("Consulta cadastrada com sucesso");
			return new ResponseEntity<>(dto, HttpStatus.CREATED);

		} catch (SQLException ex) {
			logger.debug("Erro ao cadastrar consulta");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
			
		}
	}
	
	// Deleta uma consulta pelo ID
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<ConsultaDto> delete(@PathVariable Long id){
		
		try {
		service.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
		} catch (SQLException ex) {
			logger.debug("Erro ao deletar consulta");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Lista todas as consultas
	@GetMapping("/")
	@Transactional
	public ResponseEntity<List<ConsultaDto>> findAll(){
		try {
			List<ConsultaDto> consultas = ConsultaDto.converterList(service.list());
			logger.debug("Listando todas as consultas");
			return new ResponseEntity<>(consultas, HttpStatus.OK);
			
			
		}catch (SQLException ex){
			logger.debug("Erro ao listar todas as consultas");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	
	
}
