package agenziaViaggi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import agenziaViaggi.dto.MetaDto;

import agenziaViaggi.models.Meta;

import agenziaViaggi.services.MetaService;


@RestController
@RequestMapping ("/Mete")
public class MetaController {

   @Autowired
    private MetaService metaService;

    @GetMapping("/all")
    public List<Meta> findAllMete() {
        return metaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Meta> findMetaById(@PathVariable String id) {
        try {
            Long MetaId = Long.parseLong(id);
            Meta meta = metaService.findById(MetaId);
            return ResponseEntity.ok(meta);
        } catch (NumberFormatException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @PostMapping
    public Meta nuovaMeta(@RequestBody MetaDto dto){
        return this.metaService.create(dto);
    }
    @DeleteMapping("/elimina/{idMeta}")
    public String eliminaMeta(@PathVariable Long id) {
        if(metaService.eliminaMeta(id) == true ){
            return "Eliminato con successo!";
        }else{
            return "Errore";
        }
    }
    @PutMapping("modifica/{idMeta}")
    public Meta modifiMeta(@RequestBody Meta m, Long id){
       return this.metaService.modificaMeta(m,id);
    }
}