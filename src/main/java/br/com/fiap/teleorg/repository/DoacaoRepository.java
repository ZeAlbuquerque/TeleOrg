package br.com.fiap.teleorg.repository;

import br.com.fiap.teleorg.domain.Doacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoacaoRepository extends JpaRepository<Doacao, Integer> {

    List<Doacao> findDoacaoByReceptorId(@Param("id") Integer id);

}
