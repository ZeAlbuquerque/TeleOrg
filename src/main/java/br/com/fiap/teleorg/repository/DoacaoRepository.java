package br.com.fiap.teleorg.repository;

import br.com.fiap.teleorg.domain.Doacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoacaoRepository extends JpaRepository<Doacao, Integer> {

}
