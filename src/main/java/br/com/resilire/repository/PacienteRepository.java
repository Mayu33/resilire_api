package br.com.resilire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.resilire.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{

}
