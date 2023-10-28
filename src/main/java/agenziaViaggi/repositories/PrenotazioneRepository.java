package agenziaViaggi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import agenziaViaggi.models.Pacchetto;
import agenziaViaggi.models.Prenotazione;
import agenziaViaggi.models.Utente;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long>{

List<Prenotazione> findByUtente(Utente u);
List<Prenotazione> findByPacchetto(Pacchetto pack);
}


