package br.com.ftech.clinica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ftech.clinica.domain.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{
	
	public List<Paciente> findAllByOrderByIdAsc();

	public Paciente findByNome(String name);
}
