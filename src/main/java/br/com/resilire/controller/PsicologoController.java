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

import br.com.resilire.controller.dto.PsicologoDto;
import br.com.resilire.model.Psicologo;
import br.com.resilire.service.PsicologoService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/psicologo")
@Api(value="API REST Psicologos")
@CrossOrigin(origins="*")
public class PsicologoController {

private final static Logger logger = LoggerFactory.getLogger(PacienteController.class);

	
	@Autowired
	PsicologoService service;
	
	
	@GetMapping("/{idPsicologo}")
	public ResponseEntity<List<PsicologoDto>> findById(@PathVariable("idPsicologo") Long id, Model model) {

		try {
			List<PsicologoDto> dto = PsicologoDto.converterOptional(service.findById(id));
			logger.debug("Request Psicologo por ID");
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} catch (SQLException e) {
			logger.debug("Problema ao acessar a lista de psicologos");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PsicologoDto> atualizar(@PathVariable Long id, @RequestBody @Validated Psicologo p) throws SQLException {

		Optional<Psicologo> edit = service.findById(id);
		if(edit.isPresent()) {
			Psicologo pac = edit.get();
			pac.setIdPsicologo(p.getIdPsicologo());
			pac.setCrp(p.getCrp());
			pac.setNome(p.getNome());
			pac.setSobrenome(p.getSobrenome());
			pac.setEmail(p.getEmail());
			pac.setTelefone(p.getTelefone());
			pac.setEspecialidade(p.getEspecialidade());
			service.save(pac);
			logger.debug("Psicologo atualizado com sucesso");
			return new ResponseEntity<>(new PsicologoDto(pac), HttpStatus.OK);
		} else {
			logger.debug("Erro ao atualizar psicologo");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		
		
		
	}

	@PostMapping("/")
	@Transactional
	public ResponseEntity<PsicologoDto> cadastrar(@RequestBody @Validated Psicologo psicologo) {

		try {
			
			PsicologoDto dto = new PsicologoDto(service.save(psicologo));
			logger.debug("Psicologo cadastrado com sucesso");
			return new ResponseEntity<>(dto, HttpStatus.CREATED);

		} catch (SQLException ex) {
			logger.debug("Erro ao cadastrar psicologo");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
			
		}
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<PsicologoDto> delete(@PathVariable Long id){
		
		try {
		service.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
		} catch (SQLException ex) {
			logger.debug("Erro ao deletar psicologo");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/")
	@Transactional
	public ResponseEntity<List<PsicologoDto>> findAll(){
		try {
			List<PsicologoDto> psicologos = PsicologoDto.converterList(service.list());
			logger.debug("Listando todos os psicologos");
			return new ResponseEntity<>(psicologos, HttpStatus.OK);
			
			
		}catch (SQLException ex){
			logger.debug("Erro ao listar todos os psicologos");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
}
