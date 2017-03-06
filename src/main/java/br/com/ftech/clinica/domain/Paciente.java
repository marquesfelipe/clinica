package br.com.ftech.clinica.domain;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Paciente extends Usuario{
	
	@Size(min = 3, max = 15, message = "O nome deve conter entre 3 e 10 caracteres")
	@NotEmpty(message = "O nome do paciente é obrigatório")
	private String nome;
	
	@Column(name="data_nascimento")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Past(message = "a data deve estar no passado")
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