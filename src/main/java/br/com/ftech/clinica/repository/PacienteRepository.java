package br.com.ftech.clinica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ftech.clinica.domain.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{
	
	public List<Paciente> findAllByOrderByIdAsc();
}
