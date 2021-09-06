package com.ftninformatika.jwd.modul3.cinema.service.impl;

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
            	List<Long> idZanrova = dto.getZanrovi().stream().map(ZanrDTO::getId).collect(Collectors.toList());
                List<Zanr> zanrovi = zanrService.find(idZanrova);
                film.setZanrovi(new HashSet<>(zanrovi));
            }    
		}
		return film;
	}
	
	
}
