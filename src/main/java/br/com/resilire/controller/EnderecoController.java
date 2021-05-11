package br.com.resilire.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.resilire.controller.dto.EnderecoDto;
import br.com.resilire.model.Endereco;
import br.com.resilire.repository.EnderecoRepository;
import br.com.resilire.service.EnderecoService;
import br.com.resilire.service.UfService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	UfService ufService;
	
	@Autowired
	EnderecoService enderecoService;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	/*@GetMapping
	@RequestMapping("/{id}")
	public ResponseEntity<> lista(@PathVariable Long idEndereco) {
	
		Optional<Endereco> endereco = enderecoRepository.findById(idEndereco);
		
		if(endereco.isPresent()) {
			return new ResponseEntity<>.ok(EnderecoDto.converterOptional(endereco));
		}
		return EnderecoDto.converterOptional(endereco);
		
		
	}
	

	
	/* public Page<TopicoDto> lista(@RequestParam(required = false) String nomeCurso, 
			@PageableDefault(sort = "dataCriacao", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {
		
		if (nomeCurso == null) {
			Page<Topico> topicos = topicoRepository.findAll(paginacao);
			return TopicoDto.converter(topicos);
		} else {
			Page<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso, paginacao);
			return TopicoDto.converter(topicos);
		}
	}*/
}
