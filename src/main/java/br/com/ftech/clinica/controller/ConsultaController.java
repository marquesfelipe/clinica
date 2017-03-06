package br.com.ftech.clinica.controller;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.ftech.clinica.domain.Consulta;
import br.com.ftech.clinica.service.ConsultaService;
import br.com.ftech.clinica.util.Mensagem;
import br.com.ftech.clinica.util.Mensagem.TipoMensagem;


@Controller
@RequestMapping("/consulta")
public class ConsultaController {
	
	@Autowired
	private ConsultaService service;
	

	@RequestMapping(value="/agendar", method=RequestMethod.POST)
	public String agendar(@ModelAttribute("consulta") @Valid Consulta consulta, BindingResult result, String data, String hora, Model model) {
		
		if(result.hasErrors()){	
			return "consulta.adicionar.tiles";
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat("dd-MM-yyyy");		
		Date dataConsulta;
		try {
			Date parsed = format.parse(data);
			String dataFormatada = format2.format(parsed);
			System.out.println(dataFormatada);			
			dataConsulta = sdf.parse(dataFormatada + " " + hora);
			consulta.setDataConsulta(dataConsulta);
			service.saveConsulta(consulta);
			model.addAttribute("mensagem", new Mensagem("Sucesso ao cadastrar a consulta", TipoMensagem.SUCESSO));
		} catch (ParseException e) {
			model.addAttribute("mensagem", new Mensagem("Erro ao fazer a convers�o de data/hora. Observe os padr�es a serem seguidos", TipoMensagem.ERRO));
		}
		
		return "forward:/preparaCadastroConsulta";
	}
	
	@RequestMapping(value="/detalharConsulta", method=RequestMethod.GET)
	public String detalhar(Integer idConsulta, Model model) {
		Consulta consulta = service.findById(idConsulta);
	 	model.addAttribute("consulta", consulta);
		return "realizar.atendimento.tiles";
	}
	
	@RequestMapping(value="/atender", method=RequestMethod.POST)
	public String gravarAtendimento(Consulta consulta, Model model) {
		consulta.setDataAtendimento(new Date());
		service.updateConsulta(consulta);
		model.addAttribute("mensagem", new Mensagem("Sucesso ao cadastrar o atendimento", TipoMensagem.SUCESSO));
		return "forward:/preparaCadastroAtendimento";
	}
	
	@RequestMapping(value="/listarPorPaciente", method=RequestMethod.GET)
	public @ResponseBody List<Consulta> listarPorPaciente(Long idPaciente) {
		return service.listarPorPaciente(idPaciente);
	}
}
