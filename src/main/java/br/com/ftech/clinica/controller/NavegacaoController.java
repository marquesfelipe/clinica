package br.com.ftech.clinica.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ftech.clinica.domain.Consulta;
import br.com.ftech.clinica.domain.Medico;
import br.com.ftech.clinica.domain.Paciente;
import br.com.ftech.clinica.domain.enumeration.Especialidade;
import br.com.ftech.clinica.service.PacienteService;

@Controller
public class NavegacaoController {
	
	@Autowired
	private PacienteService service;
	
	@RequestMapping(value="/preparaCadastroMedico")
	public String redirecionaCadastroMedico(Map<String, Object> map) {
		map.put("especialidades", Especialidade.values());
		map.put("medico", new Medico());		
		return "medico.cadastrar.tiles";
	}
	
	@RequestMapping(value="/preparaCadastroPaciente")
	public String redirecionaCadastroPaciente(Map<String, Object> map) {
		map.put("paciente", new Paciente());		
		return "paciente.adicionar.tiles";
	}
	
	@RequestMapping(value="/preparaCadastroConsulta")
	public String redirecionaCadastroConsulta(Map<String, Object> map) {
		map.put("especialidades", Especialidade.values());
		map.put("pacientes", service.findAllPacientes());
		map.put("consulta", new Consulta());		
		return "consulta.adicionar.tiles";
	}
	
	@RequestMapping(value="/preparaCadastroAtendimento")
	public String redirecionaCadastroAtendimento(Map<String, Object> map) {
		map.put("pacientes", service.findAllPacientes());		
		return "consulta.listar.tiles";
	}
}
