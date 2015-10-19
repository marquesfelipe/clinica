package br.com.ftech.clinica.domain.enumeration;


import java.io.Serializable;

public enum Especialidade implements Serializable {
	
	CARDIOLOGISTA("Cardiologista"),
	CLINICO_GERAL("Cl�nico Geral"),
	DERMATOLOGISTA("Dermatologista"),
	OTORRINOLARINGOLOGISTA("Otorrinolaringologista"),
	PEDIATRA("Pediatra"),
	PNEUMOLOGISTA("Pneumologista");
	
	private String descricao;
	
	private Especialidade(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
