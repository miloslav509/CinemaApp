package com.ftninformatika.jwd.modul3.cinema.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.cinema.model.Karta;
import com.ftninformatika.jwd.modul3.cinema.web.dto.KartaDTO;

@Component
public class KartaToKartaDto implements Converter<Karta, KartaDTO> {

	@Override
	public KartaDTO convert(Karta s) {
		KartaDTO dto = new KartaDTO();
		dto.setId(s.getId());
		dto.setDatumIVreme(s.getDatumIVreme().toString());
		dto.setFilmNaziv(s.getProjekcija().getFilm().getNaziv());
		dto.setProjekcijaId(s.getProjekcija().getId());
		dto.setSedisteId(s.getSediste().getId());
		dto.setKorisnikUsername(s.getKorisnik().getKorisnickoIme());;
		dto.setSedisteBroj(s.getSediste().getRedniBroj());
		dto.setProjekcijaVreme(s.getProjekcija().getDatumIVreme().toString());
		dto.setSalaNaziv(s.getProjekcija().getSala().getNaziv());
		
		return dto;
	}
	
	public List<KartaDTO> convert(List<Karta> karte){
		List<KartaDTO> dto = new ArrayList<>();
		for (Karta karta : karte) {
			dto.add(convert(karta));
		}
		
		return dto;
	}

}
