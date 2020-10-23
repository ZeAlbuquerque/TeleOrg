package br.com.fiap.teleorg.repository;


import br.com.fiap.teleorg.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    Paciente findByCpf(@Param("cpf") String cpf);

    void deleteByCpf(@Param("cpf") String cpf);
}
