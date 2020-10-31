package br.com.fiap.teleorg.repository;

import br.com.fiap.teleorg.domain.Entrega;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Integer> {

    Entrega findEntregaByDoacaoId(@Param("id") Integer id);

    @Query(value = "select * from entrega", nativeQuery = true)
    Page<Entrega> search(Pageable pageable);
}
