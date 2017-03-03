package br.com.ftech.clinica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.ftech.clinica.domain.Paciente;
import br.com.ftech.clinica.repository.PacienteRepository;

public class PacienteServiceImpl implements PacienteService{
	
	@Autowired
	private PacienteRepository repository;

	public List<Paciente> findAllPacientes() {
		return repository.findAll();
	}

	public Paciente findById(long id) {
		return repository.findOne(id);
	}

	public Paciente findByNome(String name) {
		return repository.findByNome(name);
	}

	public void savePaciente(Paciente Paciente) {
		repository.save(Paciente);
	}

	public void updatePaciente(Paciente Paciente) {
		repository.save(Paciente);
	}

	public void deletePacienteById(long id) {
		repository.delete(id);
	}

	public void deleteAllPacientes() {
		repository.deleteAll();
	}

}
