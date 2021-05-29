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
import org.springframework.web.bind.annotation.RestController;

import br.com.resilire.controller.dto.ProntuarioDto;
import br.com.resilire.model.Prontuario;
import br.com.resilire.service.ProntuarioService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/prontuario")
@Api(value="API REST Prontuarios")
@CrossOrigin(origins="*")
public class ProntuarioController {

	
	private final static Logger logger = LoggerFactory.getLogger(ProntuarioController.class);
	
	@Autowired
	ProntuarioService service;
	
	
	@GetMapping("/{idProntuario}")
	public ResponseEntity<List<ProntuarioDto>> findById(@PathVariable("idProntuario") Long id, Model model) {

		try {
			
			List<ProntuarioDto> dto = ProntuarioDto.converterOptional(service.findById(id));
			logger.debug("Request Prontuario por ID");
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} catch (SQLException e) {
			logger.debug("Problema ao acessar a lista de prontuario");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping("/paciente/{idPaciente}")
	public ResponseEntity<List<ProntuarioDto>> findByIdPaciente(@PathVariable("idPaciente") Long id, Model model) {

		try {
			List<ProntuarioDto> dto = ProntuarioDto.converterList(service.findByIdPaciente(id));
			logger.debug("Request Prontuario por ID");
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} catch (SQLException e) {
			logger.debug("Problema ao acessar a lista de prontuario");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ProntuarioDto> atualizar(@PathVariable Long id, @RequestBody @Validated Prontuario p) throws SQLException {

		Optional<Prontuario> edit = service.findById(id);
		if(edit.isPresent()) {
			Prontuario pron = edit.get();
			pron.setIdProntuario(p.getIdProntuario());
			pron.setIdPaciente(p.getIdPaciente());
			pron.setObservacao(p.getObservacao());
			pron.setPrescricao(p.getPrescricao());
			service.save(pron);
			logger.debug("Prontuario atualizada com sucesso");
			return new ResponseEntity<>(new ProntuarioDto(pron), HttpStatus.OK);
		} else {
			logger.debug("Erro ao atualizar prontuario");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		
		
		
	}

	@PostMapping("/")
	@Transactional
	public ResponseEntity<ProntuarioDto> cadastrar(@RequestBody @Validated Prontuario prontuario) {

		try {
			
			ProntuarioDto dto = new ProntuarioDto(service.save(prontuario));
			logger.debug("Prontuario cadastrado com sucesso");
			return new ResponseEntity<>(dto, HttpStatus.CREATED);

		} catch (SQLException ex) {
			logger.debug("Erro ao cadastrar prontuario");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
			
		}
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<ProntuarioDto> delete(@PathVariable Long id){
		
		try {
		service.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
		} catch (SQLException ex) {
			logger.debug("Erro ao deletar prontuario");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/")
	@Transactional
	public ResponseEntity<List<ProntuarioDto>> findAll(){
		try {
			List<ProntuarioDto> prontuarios = ProntuarioDto.converterList(service.list());
			logger.debug("Listando todos os prontuarios");
			return new ResponseEntity<>(prontuarios, HttpStatus.OK);
			
			
		}catch (SQLException ex){
			logger.debug("Erro ao listar todas os prontuarios");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
