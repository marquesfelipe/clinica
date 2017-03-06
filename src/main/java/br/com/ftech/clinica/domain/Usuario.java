package br.com.ftech.clinica.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Inheritance(strategy =InheritanceType.JOINED)
public class Usuario {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "username", length = 15, nullable = false)
	@Size(min = 3, max = 15, message = "O login deve conter entre 3 e 10 caracteres")
	@NotEmpty(message = "O login é obrigatório")
	private String username;
	
	@Size(min = 3, max = 15, message = "A senha deve conter entre 3 e 10 caracteres")
	@NotEmpty(message = "A senha é obrigatória")
	@Column(name = "password", length = 150, nullable = false)
	private String password;
	
	@Column(name = "role", length = 20, nullable =  false)
	private String role;	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
