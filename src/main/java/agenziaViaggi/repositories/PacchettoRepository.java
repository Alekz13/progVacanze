package agenziaViaggi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import agenziaViaggi.models.Pacchetto;

public interface PacchettoRepository extends JpaRepository<Pacchetto, Long> {

}
