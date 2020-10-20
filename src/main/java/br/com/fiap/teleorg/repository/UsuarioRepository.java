package br.com.fiap.teleorg.repository;

import br.com.fiap.teleorg.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
