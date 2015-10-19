package br.com.ftech.clinica.repository;



import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.ftech.clinica.domain.Consulta;


@Repository
public class ConsultaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void salvaConsulta(Consulta consulta) {
		entityManager.persist(consulta);
	}
	
	@Transactional
	public void atualizaConsulta(Consulta consulta) {
		entityManager.merge(consulta);
	}
		
	public Consulta recuperaConsulta(Integer id) {
		return entityManager.find(Consulta.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Consulta> listarPorPaciente(Integer idPaciente) {
		Query query = entityManager.createQuery("Select c from Consulta c where c.paciente.id=:idPaciente order by c.dataConsulta");
		query.setParameter("idPaciente", idPaciente);
		
		return query.getResultList();
	}
}
