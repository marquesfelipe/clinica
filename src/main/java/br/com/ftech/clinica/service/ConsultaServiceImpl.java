package br.com.ftech.clinica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.ftech.clinica.domain.Consulta;
import br.com.ftech.clinica.repository.ConsultaRepository;

@Repository
@Transactional
public class ConsultaServiceImpl implements ConsultaService {

	@Autowired
	private ConsultaRepository repository;

	public List<Consulta> listarPorPaciente(Long idPaciente) {
		return repository.listarPorPaciente(idPaciente);
	}

	public List<Consulta> findAllConsultas() {
		return repository.findAll();
	}

	public Consulta findById(long id) {
		return repository.findOne(id);
	}

	public void saveConsulta(Consulta Consulta) {
		repository.save(Consulta);
	}

	public void updateConsulta(Consulta Consulta) {
		repository.save(Consulta);
	}

	public void deleteConsultaById(long id) {
		repository.delete(id);
	}

	public void deleteAllConsultas() {
		repository.deleteAll();
	}
}
