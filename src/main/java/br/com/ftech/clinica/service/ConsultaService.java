package br.com.ftech.clinica.service;

import java.util.List;

import br.com.ftech.clinica.domain.Consulta;

public interface ConsultaService {
	
	public List<Consulta> listarPorPaciente(Long idPaciente) ;
	
	Consulta findById(long id);

	void saveConsulta(Consulta Consulta);

	void updateConsulta(Consulta Consulta);

	void deleteConsultaById(long id);

	List<Consulta> findAllConsultas();

	void deleteAllConsultas();

}
