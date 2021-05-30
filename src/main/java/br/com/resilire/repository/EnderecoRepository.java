package br.com.resilire.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.resilire.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

	public List<Endereco> findByIdPaciente(Long idPaciente);
	
	public List<Endereco> findByIdPsicologo(Long idPsicologo);
	
}
