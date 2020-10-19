package io.github.zealbuquerque.repository;

import io.github.zealbuquerque.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
