package br.com.fiap.teleorg.repository;


import br.com.fiap.teleorg.domain.Orgao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgaoRepository extends JpaRepository<Orgao, Integer> {

}
