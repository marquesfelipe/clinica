package br.com.ftech.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ftech.clinica.domain.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Usuario findByUsername(String username);

}
