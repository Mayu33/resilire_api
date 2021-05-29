package br.com.resilire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.resilire.model.Prontuario;

@Repository
public interface ProntuarioRepository extends JpaRepository<Prontuario, Long>{

}
