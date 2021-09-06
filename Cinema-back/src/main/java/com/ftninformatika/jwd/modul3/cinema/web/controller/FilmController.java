package com.ftninformatika.jwd.modul3.cinema.web.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ftninformatika.jwd.modul3.cinema.model.Film;
import com.ftninformatika.jwd.modul3.cinema.model.Projekcija;
import com.ftninformatika.jwd.modul3.cinema.model.Zanr;
import com.ftninformatika.jwd.modul3.cinema.service.FilmService;
import com.ftninformatika.jwd.modul3.cinema.service.ProjekcijaService;
import com.ftninformatika.jwd.modul3.cinema.service.ZanrService;
import com.ftninformatika.jwd.modul3.cinema.service.impl.FilmDtoToFilm;
import com.ftninformatika.jwd.modul3.cinema.support.FilmToFilmDto;
import com.ftninformatika.jwd.modul3.cinema.support.ProjekcijaToProjekcijaDto;
import com.ftninformatika.jwd.modul3.cinema.support.ZanrToZanrDto;
import com.ftninformatika.jwd.modul3.cinema.web.dto.FilmDTO;
import com.ftninformatika.jwd.modul3.cinema.web.dto.ProjekcijaDTO;
import com.ftninformatika.jwd.modul3.cinema.web.dto.ZanrDTO;

@RestController
@RequestMapping(value = "/api/filmovi", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class FilmController {

    @Autowired
    private FilmService filmService;

    @Autowired
    private ProjekcijaService projekcijaService;

    @Autowired
    private FilmDtoToFilm toFilm;

    @Autowired
    private FilmToFilmDto toFilmDto;

    @Autowired
    private ProjekcijaToProjekcijaDto toProjekcijaDto;
    
    @Autowired
    private ZanrService zanrService;
    
    @Autowired
    private ZanrToZanrDto toZanrDto;

   // @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FilmDTO> create(@Valid @RequestBody FilmDTO filmDTO){
        Film film = toFilm.convert(filmDTO);
        Film sacuvanFilm = filmService.save(film);

        return new ResponseEntity<>(toFilmDto.convert(sacuvanFilm), HttpStatus.CREATED);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FilmDTO> update(@PathVariable Long id, @Valid @RequestBody FilmDTO filmDTO){

        if(!id.equals(filmDTO.getId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Film film = toFilm.convert(filmDTO);
        Film sacuvanFilm = filmService.update(film);

        return new ResponseEntity<>(toFilmDto.convert(sacuvanFilm),HttpStatus.OK);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        Film obrisanFilm = filmService.delete(id);
        
        if(obrisanFilm != null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //@PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<FilmDTO> getOne(@PathVariable Long id){
       Film film = filmService.findOne(id);

        if(film != null) {
            return new ResponseEntity<>(toFilmDto.convert(film), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //@PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
    @GetMapping
    public ResponseEntity<List<FilmDTO>> getAll(
            @RequestParam(required=false) String naziv,
            @RequestParam(required=false) Long zanrId,
            @RequestParam(required=false) Integer trajanjeOd,
            @RequestParam(required=false) Integer trajanjeDo){

        List<Film> filmovi = filmService.find(naziv,zanrId,trajanjeOd,trajanjeDo);

        return new ResponseEntity<>(toFilmDto.convert(filmovi), HttpStatus.OK);
    }

    //@PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
    @GetMapping("/{id}/projekcije")
    public ResponseEntity<List<ProjekcijaDTO>> findByFilmId(@PathVariable @Positive(message = "Id must be positive.")  Long id){
        List<Projekcija> projekcije = projekcijaService.findByFilmId(id);

        return new ResponseEntity<>(toProjekcijaDto.convert(projekcije), HttpStatus.OK);
    }
    
    @GetMapping("/{id}/zanrovi")
    public ResponseEntity<List<ZanrDTO>> findZanrByFilmId(@PathVariable @Positive Long id){
    	List<Zanr> zanrovi = zanrService.findByFilm(id);
    	
    	return new ResponseEntity<>(toZanrDto.convert(zanrovi), HttpStatus.OK);
    }

}
