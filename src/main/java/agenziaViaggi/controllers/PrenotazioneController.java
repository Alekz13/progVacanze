package agenziaViaggi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import agenziaViaggi.dto.PrenotazioneDto;

import agenziaViaggi.models.Prenotazione;
import agenziaViaggi.services.PrenotazioneService;
import agenziaViaggi.services.UtenteService;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {

	@Autowired
	private PrenotazioneService prenotazioneService;
	@Autowired
	private UtenteService utenteService;

	@GetMapping("/{id}")
	 public Prenotazione getPrenotazioneById(@PathVariable Long id) {
        return prenotazioneService.findById(id);
}
	@GetMapping("/utente{id}")
	 public List<Prenotazione> getPrenotazioneByIdUtente(@PathVariable Long id) {
        return prenotazioneService.findByUtente(utenteService.findById(id));
	}
	@GetMapping("/utente{email}")
	 public List<Prenotazione> getPrenotazioneByEmailUtente(@PathVariable String email) {
        return prenotazioneService.findByUtente(utenteService.findByEmail(email));
	}

	  @PostMapping
    public Prenotazione nuovaPrenotazione(@RequestBody PrenotazioneDto dto){
        return this.prenotazioneService.create(dto);
    }
	   @DeleteMapping("/elimina/{idPrenotazione}")
	public String eliminaPrenotazione(@PathVariable Long id) {
		if(prenotazioneService.eliminaPrenotazione(id)== true){
            return "Eliminata con successo!";
        }else{
            return "Errore";
        }
	}
    @PutMapping("modifica/{idPrenotazione}")
    public Prenotazione modifiPrenotazione(@RequestBody Prenotazione pr, Long id){
       return this.prenotazioneService.modificaPrenotazione(pr, id);
    } 
}