package br.com.ftech.clinica.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.ftech.clinica.domain.Paciente;
import br.com.ftech.clinica.domain.Role;
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
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat("dd-MM-yyyy");
		Date dataNascimento;
		try {
			Date parsed = format.parse(data);
			String dataFormatada = format2.format(parsed);
			dataNascimento = format2.parse(dataFormatada);
			paciente.setDataNascimento(dataNascimento);
			paciente.setRole(Role.ROLE_PACIENTE.toString());
			service.savePaciente(paciente);
			model.addAttribute("paciente", new Paciente());
			model.addAttribute("mensagem", new Mensagem("Sucesso ao cadastrar o paciente", TipoMensagem.SUCESSO));
		} catch (ParseException e) {
			model.addAttribute("mensagem", new Mensagem("Erro ao fazer a conversão de data/hora. Observe os padrï¿½es a serem seguidos",
					TipoMensagem.ERRO));
		}
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
