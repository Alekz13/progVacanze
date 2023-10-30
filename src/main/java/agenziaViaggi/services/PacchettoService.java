package agenziaViaggi.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import agenziaViaggi.dto.PacchettoDto;
import agenziaViaggi.models.Pacchetto;
import agenziaViaggi.repositories.PacchettoRepository;

@Service
public class PacchettoService {

	@Autowired
	public PacchettoRepository pacchettoRepository;
	@Autowired
	public ModelMapper modelMapper;
	
	public Pacchetto findById(Long id) {
		return this.pacchettoRepository.findById(id).orElseThrow(() -> new
		ResponseStatusException(HttpStatus.NOT_FOUND));
		}
	public List<Pacchetto> findByContinente(String continente){
		List<Pacchetto> pacchetti= this.pacchettoRepository.findAll();
		for(Pacchetto p : pacchetti) {
			if(p.getMeta().getContinente()== continente) {
				pacchetti.add(p);
			}
		} return pacchetti;
		
	}
	
	public Pacchetto create(PacchettoDto dto) {
		modelMapper.getConfiguration()
		.setMatchingStrategy(MatchingStrategies.LOOSE);
		Pacchetto p = new Pacchetto();
		p = modelMapper.map(dto, Pacchetto.class);
		return this.pacchettoRepository.save(p);
		}

	public List<Pacchetto> findAll() {
		return pacchettoRepository.findAll();
	}
		public boolean eliminaPacchetto(Long id) {
		if(pacchettoRepository.existsById(id)) {
			pacchettoRepository.deleteById(id);
			return true;
		}
		return false;
	}

	public Pacchetto  modificaPachetto(Pacchetto pack , Long id) {
		Optional<Pacchetto> pacchetto = pacchettoRepository.findById(id);
			if(pacchetto.isPresent()){
			Pacchetto p = pacchetto.get();
			p.setCosto(pack.getCosto());
			p.setDescrizione(pack.getDescrizione());
			p.setDisponibilita(pack.getDisponibilita());
			p.setGiornoPartenza(pack.getGiornoPartenza());
			p.setGiornoRitorno(pack.getGiornoRitorno());
			p.setImg(pack.getImg());
			p.setMeta(pack.getMeta());
			p.setNome(pack.getNome());
			p.setPassaporto(pack.isPassaporto());
			p.setVaccino(pack.isVaccino());
			

			pacchettoRepository.save(p);
			
			return p;
		}
		return null;

}
}