package br.com.ftech.clinica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ftech.clinica.domain.Consulta;


@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long>{
	
	
	@Query("Select c from Consulta c where c.paciente.id=:idPaciente order by c.dataConsulta")
	List<Consulta> listarPorPaciente(@Param("idPaciente")Long idPaciente);

}
