package com.ftninformatika.jwd.modul3.cinema.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.cinema.model.Sala;
import com.ftninformatika.jwd.modul3.cinema.service.SalaService;
import com.ftninformatika.jwd.modul3.cinema.web.dto.SalaDTO;

@Component
public class SalaDtoToSala implements Converter<SalaDTO, Sala> {

	@Autowired
	private SalaService salaService;

	@Override
	public Sala convert(SalaDTO dto) {
		Sala sala;
		if (dto.getId() != null) {
			sala = salaService.findOne(dto.getId());
		}else {
			sala = new Sala();
		}
		
		if (sala != null) {
			sala.setNaziv(dto.getNaziv());
		}
		return sala;
	}
	
	
}
