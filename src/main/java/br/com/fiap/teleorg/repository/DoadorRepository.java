package br.com.fiap.teleorg.repository;


import br.com.fiap.teleorg.domain.Doador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoadorRepository extends JpaRepository<Doador, Integer> {
}
