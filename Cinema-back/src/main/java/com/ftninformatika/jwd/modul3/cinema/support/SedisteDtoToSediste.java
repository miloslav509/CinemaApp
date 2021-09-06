package com.ftninformatika.jwd.modul3.cinema.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.cinema.model.Sediste;
import com.ftninformatika.jwd.modul3.cinema.service.SedisteService;
import com.ftninformatika.jwd.modul3.cinema.web.dto.SedisteDTO;

@Component
public class SedisteDtoToSediste implements Converter<SedisteDTO, Sediste> {

	@Autowired
	private SedisteService sedisteService;

	@Override
	public Sediste convert(SedisteDTO dto) {
		Sediste sediste;
		if (dto.getId() != null) {
			sediste = sedisteService.findOne(dto.getId());
		}else {
			sediste = new Sediste();
		}
		
		if (sediste != null) {
			sediste.setRedniBroj(dto.getRedniBroj());
		}
		return sediste;
	}
	
	
}
