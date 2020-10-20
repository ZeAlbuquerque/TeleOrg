package br.com.fiap.teleorg.repository;


import br.com.fiap.teleorg.domain.Doador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoadorRepository extends JpaRepository<Doador, Integer> {

    @Query(value = "select * from doador d where d.nome like '%:nome%' ", nativeQuery = true)
    List<Doador> findByName(@Param("nome") String nome);


}
