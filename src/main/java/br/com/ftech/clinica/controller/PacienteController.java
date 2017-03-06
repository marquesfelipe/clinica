package br.com.ftech.clinica.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.ftech.clinica.domain.Paciente;
import br.com.ftech.clinica.domain.enumeration.Role;
import br.com.ftech.clinica.service.PacienteService;
import br.com.ftech.clinica.util.Mensagem;
import br.com.ftech.clinica.util.Mensagem.TipoMensagem;

@Controller
@RequestMapping("/paciente")
public class PacienteController {

	@Autowired
	private PacienteService service;
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public String cadastrar(@ModelAttribute("paciente") @Valid Paciente paciente,BindingResult result, String data, Model model) {
		if(result.hasErrors()){	
			return "paciente.adicionar.tiles";
		}		
		paciente.setRole(Role.ROLE_PACIENTE.toString());
		service.savePaciente(paciente);
		model.addAttribute("paciente", new Paciente());
    	model.addAttribute("mensagem", new Mensagem("Sucesso ao cadastrar o paciente", TipoMensagem.SUCESSO));
		return "paciente.adicionar.tiles";
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(Model model) {
		List<Paciente> pacientes = service.findAllPacientes();
		model.addAttribute("pacientes", pacientes);
		return "paciente.listar.tiles";
	}

	@RequestMapping(value = "/excluir", method = RequestMethod.GET)
	public String excluir(Integer idPaciente, Model model) {
		service.deletePacienteById(idPaciente);
		model.addAttribute("mensagem", new Mensagem("Sucesso ao excluir o paciente", TipoMensagem.SUCESSO));
		return "forward:paciente.listar.tiles";
	}
}
