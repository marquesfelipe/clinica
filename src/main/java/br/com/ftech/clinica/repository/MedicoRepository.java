package br.com.ftech.clinica.repository;


import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.ftech.clinica.domain.Medico;
import br.com.ftech.clinica.domain.enumeration.Especialidade;



@Repository
public class MedicoRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void salvaMedico(Medico medico) {
		entityManager.persist(medico);
	}
	
	@Transactional
	public void excluiMedico(Integer id) {
		Medico medico = entityManager.find(Medico.class, id);
		entityManager.remove(medico);
	}
	
	@SuppressWarnings("unchecked")
	public List<Medico> listaMedicos() {
		Query query = entityManager.createQuery("Select m from Medico m order by m.id");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Medico> listaMedicosPorEspecialidade(Especialidade especialidade) {
		Query query = entityManager.createQuery("Select m from Medico m where m.especialidade=:especialidade order by m.nome");
		query.setParameter("especialidade", especialidade);
		
		return query.getResultList();
	}
}
