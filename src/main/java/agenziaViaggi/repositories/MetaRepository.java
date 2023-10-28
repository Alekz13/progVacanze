package agenziaViaggi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import agenziaViaggi.models.Meta;

public interface MetaRepository extends JpaRepository<Meta, Long> {
public Meta findByCitta(String citta);
}