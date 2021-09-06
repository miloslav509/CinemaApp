package com.ftninformatika.jwd.modul3.cinema.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.cinema.model.Zanr;
import com.ftninformatika.jwd.modul3.cinema.service.ZanrService;
import com.ftninformatika.jwd.modul3.cinema.web.dto.ZanrDTO;

@Component
public class ZanrDtoToZanr implements Converter<ZanrDTO, Zanr> {

	@Autowired
	private ZanrService zanrService;

	@Override
	public Zanr convert(ZanrDTO dto) {
		Zanr zanr;
		if (dto.getId() != null) {
			zanr = zanrService.findOne(dto.getId());
		}else {
			zanr = new Zanr();
		}
		
		if (zanr != null) {
			zanr.setNaziv(dto.getNaziv());
		}
		return zanr;
	}
	
	
}
