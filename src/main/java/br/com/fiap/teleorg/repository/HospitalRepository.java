package br.com.fiap.teleorg.repository;

import br.com.fiap.teleorg.domain.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
}
