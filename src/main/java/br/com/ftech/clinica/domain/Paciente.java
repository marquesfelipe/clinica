package br.com.ftech.clinica.domain;


import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Paciente extends Usuario{
	
	private String nome;
	
	@Column(name="data_nascimento")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dataNascimento;

	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}