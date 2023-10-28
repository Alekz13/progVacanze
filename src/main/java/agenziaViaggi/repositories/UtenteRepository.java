package agenziaViaggi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import agenziaViaggi.models.Utente;

public interface UtenteRepository extends JpaRepository<Utente, Long>{

    public Utente findByEmailAddress(String email);
}
