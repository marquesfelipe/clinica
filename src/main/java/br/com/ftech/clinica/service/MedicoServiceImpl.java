package br.com.ftech.clinica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ftech.clinica.domain.Medico;
import br.com.ftech.clinica.domain.enumeration.Especialidade;
import br.com.ftech.clinica.repository.MedicoRepository;

@Service
@Transactional
public class MedicoServiceImpl implements MedicoService {

	@Autowired
	private MedicoRepository repository;

	public List<Medico> listaMedicosPorEspecialidade(Especialidade especialidade) {
		return repository.listaMedicosPorEspecialidade(especialidade.toString());
	}
	
	public List<Medico> findAllMedicos() {
		return repository.findAll();
	}

	public Medico findById(long id) {
		return repository.findOne(id);
	}

	public Medico findByName(String name) {
		return repository.findByNome(name);
	}

	public void saveMedico(Medico Medico) {
		repository.save(Medico);
	}

	public void updateMedico(Medico Medico) {
		repository.save(Medico);
	}

	public void deleteMedicoById(long id) {
		repository.delete(id);
	}

	public void deleteAllMedicos() {
		repository.deleteAll();
	}
}
