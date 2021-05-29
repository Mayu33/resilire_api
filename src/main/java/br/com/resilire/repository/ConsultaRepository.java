package br.com.resilire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.resilire.model.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long>{

}
