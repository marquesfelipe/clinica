package br.com.ftech.clinica.domain;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.ftech.clinica.domain.enumeration.Especialidade;


@Entity
public class Medico extends Usuario {

	private String nome;
	
	@Enumerated(EnumType.STRING)
	private Especialidade especialidade;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Especialidade getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	
}
