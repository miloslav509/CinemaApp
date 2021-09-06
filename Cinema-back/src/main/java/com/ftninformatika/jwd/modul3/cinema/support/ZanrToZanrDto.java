package com.ftninformatika.jwd.modul3.cinema.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.cinema.model.Tip;
import com.ftninformatika.jwd.modul3.cinema.model.Zanr;
import com.ftninformatika.jwd.modul3.cinema.web.dto.TipDTO;
import com.ftninformatika.jwd.modul3.cinema.web.dto.ZanrDTO;

@Component
public class ZanrToZanrDto implements Converter<Zanr, ZanrDTO> {

	@Override
	public ZanrDTO convert(Zanr s) {
		ZanrDTO dto = new ZanrDTO();
		dto.setId(s.getId());
		dto.setNaziv(s.getNaziv());
		return dto;
	}
	
	public List<ZanrDTO> convert(List<Zanr> zanrovi){
		List<ZanrDTO> dto = new ArrayList<>();
		
		for (Zanr zanr: zanrovi) {
			dto.add(convert(zanr));
		}
		
		return dto;
	}

	
}
