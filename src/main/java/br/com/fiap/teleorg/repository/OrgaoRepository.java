package br.com.fiap.teleorg.repository;


import br.com.fiap.teleorg.domain.Orgao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrgaoRepository extends JpaRepository<Orgao, Integer> {

    @Query(value = "select * from orgao o where o.paciente_id = :id ", nativeQuery = true)
    List<Orgao> findByPaciente(@Param("id") Integer id);
}
