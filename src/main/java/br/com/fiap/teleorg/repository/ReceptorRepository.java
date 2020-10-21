package br.com.fiap.teleorg.repository;
import br.com.fiap.teleorg.domain.Receptor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceptorRepository extends JpaRepository<Receptor, Integer> {
}
