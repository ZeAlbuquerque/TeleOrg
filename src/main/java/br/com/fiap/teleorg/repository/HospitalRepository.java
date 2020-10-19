package io.github.zealbuquerque.repository;

import io.github.zealbuquerque.domain.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
}
