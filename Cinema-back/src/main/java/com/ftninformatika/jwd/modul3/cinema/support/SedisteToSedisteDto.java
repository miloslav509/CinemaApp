package com.ftninformatika.jwd.modul3.cinema.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.cinema.model.Sediste;
import com.ftninformatika.jwd.modul3.cinema.model.Tip;
import com.ftninformatika.jwd.modul3.cinema.web.dto.SedisteDTO;
import com.ftninformatika.jwd.modul3.cinema.web.dto.TipDTO;

@Component
public class SedisteToSedisteDto implements Converter<Sediste, SedisteDTO> {

	@Override
	public SedisteDTO convert(Sediste s) {
		SedisteDTO dto = new SedisteDTO();
		dto.setId(s.getId());
		dto.setRedniBroj(s.getRedniBroj());
		return dto;
	}
	
	public List<SedisteDTO> convert(List<Sediste> sedista){
		List<SedisteDTO> dto = new ArrayList<>();
		
		for (Sediste sed: sedista) {
			dto.add(convert(sed));
		}
		
		return dto;
	}

	
}
