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

import br.com.resilire.controller.dto.EnderecoDto;
import br.com.resilire.model.Endereco;
import br.com.resilire.service.EnderecoService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/endereco")
@Api(value="API REST Endereços")
@CrossOrigin(origins="*")
public class EnderecoController {

	private final static Logger logger = LoggerFactory.getLogger(EnderecoController.class);
	

	@Autowired
	EnderecoService enderecoService;
	

	@GetMapping("/{idEndereco}")
	public ResponseEntity<List<EnderecoDto>> findById(@PathVariable("idEndereco") Long id, Model model) {

		try {
			List<EnderecoDto> enderecoDto = EnderecoDto.converterOptional(enderecoService.findById(id));
			logger.debug("Request Enderecos por ID");
			return new ResponseEntity<>(enderecoDto, HttpStatus.OK);
		} catch (SQLException e) {
			logger.debug("Problema ao acessar a lista de enderecos");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<EnderecoDto> atualizar(@PathVariable Long id, @RequestBody @Validated Endereco e) throws SQLException {

		Optional<Endereco> enderecoEdit = enderecoService.findById(id);
		if(enderecoEdit.isPresent()) {
			Endereco end = enderecoEdit.get();
			end.setIdEndereco(e.getIdEndereco());
			end.setCep(e.getCep());
			end.setRua(e.getRua());
			end.setNumero(e.getNumero());
			end.setComplemento(e.getComplemento());
			end.setBairro(e.getBairro());
			end.setCidade(e.getCidade());
			end.setUf(e.getUf());
			enderecoService.save(end);
			logger.debug("Endereco atualizado com sucesso");
			return new ResponseEntity<>(new EnderecoDto(end), HttpStatus.OK);
		} else {
			logger.debug("Erro ao atualizar endereco");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		
		
		
	}

	@PostMapping("/")
	@Transactional
	public ResponseEntity<EnderecoDto> cadastrar(@RequestBody @Validated Endereco endereco) {

		try {
			
			EnderecoDto endDto = new EnderecoDto(enderecoService.save(endereco));
			logger.debug("Endereco cadastrado com sucesso");
			return new ResponseEntity<>(endDto, HttpStatus.CREATED);

		} catch (SQLException ex) {
			logger.debug("Erro ao cadastrar endereço");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
			
		}
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<EnderecoDto> delete(@PathVariable Long id){
		
		try {
		enderecoService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
		} catch (SQLException ex) {
			logger.debug("Erro ao deletar endereco");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
