package com.ftninformatika.jwd.modul3.cinema.support;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.cinema.model.Film;
import com.ftninformatika.jwd.modul3.cinema.model.Zanr;
import com.ftninformatika.jwd.modul3.cinema.web.dto.FilmDTO;

@Component
public class FilmToFilmDto implements Converter<Film, FilmDTO> {

	@Autowired
	private ZanrToZanrDto zanrToZanrDto;
	
	@Override
	public FilmDTO convert(Film s) {
		FilmDTO dto = new FilmDTO();
		dto.setId(s.getId());
		dto.setNaziv(s.getNaziv());
		dto.setReziser(s.getReziser());
		dto.setTrajanje(s.getTrajanje());
		dto.setGodinaProizvodnje(s.getGodinaProizvodnje());
		dto.setZemljaPorekla(s.getZemljaPorekla());
		LinkedHashMap<Long, String> zanroviMap = new LinkedHashMap<>();
        for (Zanr zanr: s.getZanrovi()) {
            zanroviMap.put(zanr.getId(), zanr.getNaziv());
        }
        dto.setZanrovi(zanroviMap);
        dto.setOpis(s.getOpis());
        return dto;
	}
	
	public List<FilmDTO> convert(List<Film> filmovi){
		List<FilmDTO> dto = new ArrayList<>();
		for (Film film : filmovi) {
			dto.add(convert(film));
		}
		
		return dto;
	}

	
}
