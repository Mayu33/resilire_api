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

import br.com.resilire.controller.dto.PacienteDto;
import br.com.resilire.model.Paciente;
import br.com.resilire.service.PacienteService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/paciente")
@Api(value="API REST Pacientes")
@CrossOrigin(origins="*")
public class PacienteController {
	
	private final static Logger logger = LoggerFactory.getLogger(PacienteController.class);

	
	@Autowired
	PacienteService service;
	
	
	@GetMapping("/{idPaciente}")
	public ResponseEntity<List<PacienteDto>> findById(@PathVariable("idPaciente") Long id, Model model) {

		try {
			List<PacienteDto> dto = PacienteDto.converterOptional(service.findById(id));
			logger.debug("Request Pacientes por ID");
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} catch (SQLException e) {
			logger.debug("Problema ao acessar a lista de pacientes");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PacienteDto> atualizar(@PathVariable Long id, @RequestBody @Validated Paciente p) throws SQLException {

		Optional<Paciente> edit = service.findById(id);
		if(edit.isPresent()) {
			Paciente pac = edit.get();
			pac.setIdPaciente(p.getIdPaciente());
			pac.setCpf(p.getCpf());
			pac.setSexo(p.getSexo());
			pac.setNome(p.getNome());
			pac.setSobrenome(p.getSobrenome());
			pac.setEmail(p.getEmail());
			pac.setTelefone(p.getTelefone());
			pac.setIdEndereco(p.getIdEndereco());
			service.save(pac);
			logger.debug("Paciente atualizado com sucesso");
			return new ResponseEntity<>(new PacienteDto(pac), HttpStatus.OK);
		} else {
			logger.debug("Erro ao atualizar paciente");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		
		
		
	}

	@PostMapping("/")
	@Transactional
	public ResponseEntity<PacienteDto> cadastrar(@RequestBody @Validated Paciente paciente) {

		try {
			
			PacienteDto dto = new PacienteDto(service.save(paciente));
			logger.debug("Paciente cadastrado com sucesso");
			return new ResponseEntity<>(dto, HttpStatus.CREATED);

		} catch (SQLException ex) {
			logger.debug("Erro ao cadastrar paciente");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
			
		}
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<PacienteDto> delete(@PathVariable Long id){
		
		try {
		service.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
		} catch (SQLException ex) {
			logger.debug("Erro ao deletar paciente");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/")
	@Transactional
	public ResponseEntity<List<PacienteDto>> findAll(){
		try {
			List<PacienteDto> pacientes = PacienteDto.converterList(service.list());
			logger.debug("Listando todos os pacientes");
			return new ResponseEntity<>(pacientes, HttpStatus.OK);
			
			
		}catch (SQLException ex){
			logger.debug("Erro ao listar todos os pacientes");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
}
