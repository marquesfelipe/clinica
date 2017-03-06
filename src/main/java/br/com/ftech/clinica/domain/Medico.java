package br.com.ftech.clinica.domain;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.ftech.clinica.domain.enumeration.Especialidade;


@Entity
@PrimaryKeyJoinColumn(name="id")
public class Medico extends Usuario {
	
	@Size(min = 3, max = 15, message = "O nome deve conter entre 3 e 10 caracteres")
	@NotEmpty(message = "O nome do m�dico � obrigat�rio")
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
