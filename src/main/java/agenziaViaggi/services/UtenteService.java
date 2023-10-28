package agenziaViaggi.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import agenziaViaggi.dto.UtenteDto;
import agenziaViaggi.models.Utente;
import agenziaViaggi.repositories.UtenteRepository;

	@Service
	public class UtenteService {

		@Autowired
		public UtenteRepository utenteRepository;
		@Autowired
		public ModelMapper modelMapper;

		public Utente findById(Long id) {
		return this.utenteRepository.findById(id).orElseThrow(() -> new
		ResponseStatusException(HttpStatus.NOT_FOUND));
		}
		
		public Utente create(UtenteDto dto) {
			modelMapper.getConfiguration()
		.setMatchingStrategy(MatchingStrategies.LOOSE);
		Utente u = new Utente();
		u = modelMapper.map(dto, Utente.class);
		return this.utenteRepository.save(u);
		}

		public List<Utente> findAll() {
			return utenteRepository.findAll();
		}

		public Utente findByEmail(String email) {
			return this.utenteRepository.findByEmailAddress(email);
	}
	public boolean eliminaUtente(Long id) {
		if(utenteRepository.existsById(id)) {
			utenteRepository.deleteById(id);
			return true;
		}
		return false;
	}

	public Utente modificaUtente(Utente user, Long id) {
		Optional<Utente> utente = utenteRepository.findById(id);
			if(utente.isPresent()){
			Utente u = utente.get();
			u.setNome(user.getNome());
			u.setCognome(user.getCognome());
			u.setDataDiNascita(user.getDataDiNascita());
			u.setEmailAddress(user.getEmailAddress());
			u.changePassword(user.getPassword());
			u.setPhoneNumber(user.getPhoneNumber());
			utenteRepository.save(u);
			
			return u;
		}
		return null;
	}
}

