package agenziaViaggi.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import agenziaViaggi.dto.MetaDto;
import agenziaViaggi.models.Meta;
import agenziaViaggi.repositories.MetaRepository;


@Service
public class MetaService {
    @Autowired
    public MetaRepository metaRepository;
    @Autowired
    public ModelMapper modelMapper;

    public Meta findById(Long id) {
        return this.metaRepository.findById(id).orElseThrow(() -> new
        ResponseStatusException(HttpStatus.NOT_FOUND));
        }

    public Meta create(MetaDto dto) {
        modelMapper.getConfiguration()
        .setMatchingStrategy(MatchingStrategies.LOOSE);
        Meta m  = new Meta();
        m = modelMapper.map(dto, Meta.class);
        return this.metaRepository.save(m);
        }

    public List<Meta> findAll() {
        return metaRepository.findAll();
    }
        public boolean eliminaMeta(Long id) {
        if(metaRepository.existsById(id)) {
        metaRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public Meta findByCitta(String citta) {
			return this.metaRepository.findByCitta(citta);
	}

    public Meta  modificaMeta(Meta met , Long id) {
        Optional<Meta> meta =metaRepository.findById(id);
            if(meta.isPresent()){
            Meta m = meta.get();
            m.setCitta(met.getCitta());
            m.setContinente(met.getContinente());
            m.setStato(met.getStato());

            metaRepository.save(m);
            return m;
        }
        return null;

}
}