package br.com.fiap.teleorg.repository;

import br.com.fiap.teleorg.domain.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Integer> {

    Entrega findEntregaByDoacaoId(@Param("id") Integer id);
}
