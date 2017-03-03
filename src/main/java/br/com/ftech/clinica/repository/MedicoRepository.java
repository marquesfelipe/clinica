package br.com.ftech.clinica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ftech.clinica.domain.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long>{

		Medico findByNome(String nome);
		
		@Query("Select m from Medico m where m.especialidade=:especialidade order by m.nome")
		List<Medico> listaMedicosPorEspecialidade(@Param("especialidade")String especialidade);
		

}
