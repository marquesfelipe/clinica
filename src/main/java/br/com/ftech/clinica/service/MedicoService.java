package br.com.ftech.clinica.service;

import java.util.List;

import br.com.ftech.clinica.domain.Medico;
import br.com.ftech.clinica.domain.enumeration.Especialidade;

public interface MedicoService {
	
	public List<Medico> listaMedicosPorEspecialidade(Especialidade especialidade) ;
	
	Medico findById(long id);

	Medico findByName(String name);

	void saveMedico(Medico Medico);

	void updateMedico(Medico Medico);

	void deleteMedicoById(long id);

	List<Medico> findAllMedicos();

	void deleteAllMedicos();

}
