package com.ftninformatika.jwd.modul3.cinema.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.cinema.model.Tip;
import com.ftninformatika.jwd.modul3.cinema.service.TipService;
import com.ftninformatika.jwd.modul3.cinema.web.dto.TipDTO;

@Component
public class TipDtoToTip implements Converter<TipDTO, Tip> {

	@Autowired
	private TipService tipService;

	@Override
	public Tip convert(TipDTO dto) {
		Tip tip;
		if (dto.getId() != null) {
			tip = tipService.findOne(dto.getId());
		}else {
			tip = new Tip();
		}
		
		if (tip != null) {
			tip.setNaziv(dto.getNaziv());
		}
		return tip;
	}
	
	
}
