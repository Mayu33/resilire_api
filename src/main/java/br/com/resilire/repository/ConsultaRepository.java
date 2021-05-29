package br.com.resilire.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.resilire.model.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long>{

	public List<Consulta> findByIdPaciente(Long idPaciente);
	
	public List<Consulta> findByIdPsicologo(Long idPsicologo);
}
