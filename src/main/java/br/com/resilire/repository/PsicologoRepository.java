package br.com.resilire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.resilire.model.Psicologo;

@Repository
public interface PsicologoRepository extends JpaRepository<Psicologo, Long>{

}
