package com.ftninformatika.jwd.modul3.cinema.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.cinema.model.Tip;
import com.ftninformatika.jwd.modul3.cinema.web.dto.TipDTO;

@Component
public class TipToTipDto implements Converter<Tip, TipDTO> {

	@Override
	public TipDTO convert(Tip s) {
		TipDTO dto = new TipDTO();
		dto.setId(s.getId());
		dto.setNaziv(s.getNaziv());
		return dto;
	}
	
	public List<TipDTO> convert(List<Tip> tipovi){
		List<TipDTO> dto = new ArrayList<>();
		
		for (Tip tip : tipovi) {
			dto.add(convert(tip));
		}
		
		return dto;
	}

	
}
