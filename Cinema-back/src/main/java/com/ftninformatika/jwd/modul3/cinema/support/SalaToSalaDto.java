package com.ftninformatika.jwd.modul3.cinema.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.cinema.model.Sala;
import com.ftninformatika.jwd.modul3.cinema.model.Tip;
import com.ftninformatika.jwd.modul3.cinema.web.dto.SalaDTO;
import com.ftninformatika.jwd.modul3.cinema.web.dto.TipDTO;

@Component
public class SalaToSalaDto implements Converter<Sala, SalaDTO> {

	@Override
	public SalaDTO convert(Sala s) {
		SalaDTO dto = new SalaDTO();
		dto.setId(s.getId());
		dto.setNaziv(s.getNaziv());
		return dto;
	}
	
	public List<SalaDTO> convert(List<Sala> sale){
		List<SalaDTO> dto = new ArrayList<>();
		
		for (Sala sala: sale) {
			dto.add(convert(sala));
		}
		
		return dto;
	}

	
}
