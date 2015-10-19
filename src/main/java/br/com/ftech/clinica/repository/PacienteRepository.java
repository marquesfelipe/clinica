package br.com.ftech.clinica.repository;



import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.ftech.clinica.domain.Paciente;


@Repository
public class PacienteRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void salvaPaciente(Paciente paciente) {
		entityManager.persist(paciente);
	}
	
	@Transactional
	public void excluiPaciente(Integer id) {
		Paciente paciente = entityManager.find(Paciente.class, id);
		entityManager.remove(paciente);
	}
	
	@SuppressWarnings("unchecked")
	public List<Paciente> listaPacientes() {
		Query query = entityManager.createQuery("Select p from Paciente p order by p.id");
		return query.getResultList();
	}
}
