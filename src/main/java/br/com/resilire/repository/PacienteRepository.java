package br.com.resilire.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.resilire.model.Paciente;


public interface PacienteRepository extends JpaRepository<Paciente, Long>{

}
