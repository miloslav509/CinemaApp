package com.ftninformatika.jwd.modul3.cinema.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.cinema.model.Projekcija;
import com.ftninformatika.jwd.modul3.cinema.web.dto.ProjekcijaDTO;

@Component
public class ProjekcijaToProjekcijaDto implements Converter<Projekcija, ProjekcijaDTO> {

	@Override
	public ProjekcijaDTO convert(Projekcija s) {
		ProjekcijaDTO dto = new ProjekcijaDTO();
		dto.setId(s.getId());
		dto.setAdministratorUsername(s.getAdministrator().getKorisnickoIme());;
		dto.setDatumIVreme(s.getDatumIVreme().toString());
		dto.setFilmId(s.getFilm().getId());
		dto.setFilmNaziv(s.getFilm().getNaziv());
		dto.setSalaId(s.getSala().getId());
		dto.setSalaNaziv(s.getSala().getNaziv());
		dto.setTipId(s.getTip().getId());
		dto.setTipNaziv(s.getTip().getNaziv());
		dto.setCenaKarte(s.getCenaKarte());
		return dto;
	}
	
	public List<ProjekcijaDTO> convert(List<Projekcija> projekcije){
		List<ProjekcijaDTO> dto = new ArrayList<>();
		
		for (Projekcija projekcija : projekcije) {
			dto.add(convert(projekcija));
		}
		
		return dto;
	}

	
}
