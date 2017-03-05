package br.com.ftech.clinica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.ftech.clinica.domain.Medico;
import br.com.ftech.clinica.domain.Role;
import br.com.ftech.clinica.domain.enumeration.Especialidade;
import br.com.ftech.clinica.service.MedicoService;
import br.com.ftech.clinica.util.Mensagem;
import br.com.ftech.clinica.util.Mensagem.TipoMensagem;

@Controller
@RequestMapping("/medico")
public class MedicoController {

	@Autowired
	private MedicoService service;

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public String cadastrar(Medico medico, Model model) {
		medico.setRole(Role.ROLE_MEDICO.toString());
		service.saveMedico(medico);
		model.addAttribute("medico", new Medico());
		model.addAttribute("especialidades", Especialidade.values());
		model.addAttribute("mensagem", new Mensagem("Sucesso ao cadastrar o médico", TipoMensagem.SUCESSO));

		return "medico.cadastrar.tiles";
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(Model model) {
		List<Medico> medicos = service.findAllMedicos();
		model.addAttribute("medicos", medicos);

		return "medico.listar.tiles";
	}

	@RequestMapping(value = "/excluir", method = RequestMethod.GET)
	public String excluir(Integer idMedico, Model model) {
		service.deleteMedicoById(idMedico);
		model.addAttribute("mensagem", new Mensagem("Sucesso ao excluir o mï¿½dico", TipoMensagem.SUCESSO));
		return "forward:medico.listar.tiles";
	}

	@RequestMapping(value="/listarPorEspecialidade", method=RequestMethod.GET)
	public @ResponseBody List<Medico> listarPorEspecialidade(Especialidade especialidade) {
		return service.listaMedicosPorEspecialidade(especialidade);
	}
}
