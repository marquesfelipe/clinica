package br.com.ftech.clinica.service;

import java.util.List;

import br.com.ftech.clinica.domain.Paciente;

public interface PacienteService {
	
	Paciente findById(long id);

	Paciente findByNome(String name);

	void savePaciente(Paciente Paciente);

	void updatePaciente(Paciente Paciente);

	void deletePacienteById(long id);

	List<Paciente> findAllPacientes();

	void deleteAllPacientes();
}
