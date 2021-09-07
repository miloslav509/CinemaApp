package com.ftninformatika.jwd.modul3.cinema.support;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.cinema.model.Film;
import com.ftninformatika.jwd.modul3.cinema.model.Zanr;
import com.ftninformatika.jwd.modul3.cinema.service.FilmService;
import com.ftninformatika.jwd.modul3.cinema.service.ZanrService;
import com.ftninformatika.jwd.modul3.cinema.web.dto.FilmDTO;
import com.ftninformatika.jwd.modul3.cinema.web.dto.ZanrDTO;

@Component
public class FilmDtoToFilm implements Converter<FilmDTO, Film> {

	@Autowired
	private FilmService filmService;

	@Autowired
	private ZanrService zanrService;
	
	@Override
	public Film convert(FilmDTO dto) {
		Film film;
		if (dto.getId() != null) {
			film = filmService.findOne(dto.getId());
		}else {
			film = new Film();
		}
		
		if (film != null) {
			film.setNaziv(dto.getNaziv());
            film.setTrajanje(dto.getTrajanje());
            film.setGodinaProizvodnje(dto.getGodinaProizvodnje());
            film.setOpis(dto.getOpis());
            film.setReziser(dto.getReziser());
            film.setZemljaPorekla(dto.getZemljaPorekla());
            
            if(dto.getZanrovi() != null) {
            	List<Zanr> zanrovi = zanrService.find(new ArrayList<>(dto.getZanrovi().keySet()));
                film.setZanrovi(new HashSet<>(zanrovi));
            }    
		}
		return film;
	}
	
	
}
