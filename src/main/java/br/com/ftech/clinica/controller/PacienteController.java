package br.com.ftech.clinica.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.ftech.clinica.domain.Paciente;
import br.com.ftech.clinica.repository.PacienteRepository;
import br.com.ftech.clinica.util.Mensagem;
import br.com.ftech.clinica.util.Mensagem.TipoMensagem;

@Controller
@RequestMapping("/paciente")
public class PacienteController {

	@Autowired
	private PacienteRepository pacienteRepository;

	@RequestMapping(value = "/cadastrar.do", method = RequestMethod.POST)
	public String cadastrar(Paciente paciente, String data, Model model) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat("dd-MM-yyyy");
		Date dataNascimento;
		try {
			Date parsed = format.parse(data);
			String dataFormatada = format2.format(parsed);
			dataNascimento = format2.parse(dataFormatada);
			paciente.setDataNascimento(dataNascimento);
			pacienteRepository.salvaPaciente(paciente);
			model.addAttribute("paciente", new Paciente());
			model.addAttribute("mensagem", new Mensagem("Sucesso ao cadastrar o paciente", TipoMensagem.SUCESSO));
		} catch (ParseException e) {
			model.addAttribute("mensagem", new Mensagem("Erro ao fazer a convers�o de data/hora. Observe os padr�es a serem seguidos",
					TipoMensagem.ERRO));
		}
		return "cadastrarPaciente";
	}

	@RequestMapping(value = "/listar.do", method = RequestMethod.GET)
	public String listar(Model model) {
		List<Paciente> pacientes = pacienteRepository.listaPacientes();
		model.addAttribute("pacientes", pacientes);

		return "listarPacientes";
	}

	@RequestMapping(value = "/excluir.do", method = RequestMethod.GET)
	public String excluir(Integer idPaciente, Model model) {
		pacienteRepository.excluiPaciente(idPaciente);
		model.addAttribute("mensagem", new Mensagem("Sucesso ao excluir o paciente", TipoMensagem.SUCESSO));

		return "forward:/paciente/listar.do";
	}
}
