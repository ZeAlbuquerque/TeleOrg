package br.com.fiap.teleorg.repository;


import br.com.fiap.teleorg.domain.Doador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


public interface DoadorRepository extends JpaRepository<Doador, Integer> {
    Doador findByCpf(@Param("cpf") String cpf);

    void deleteByCpf(@Param("cpf") String cpf);
}
