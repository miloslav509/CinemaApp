package com.ftninformatika.jwd.modul3.cinema.support;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.cinema.model.Karta;
import com.ftninformatika.jwd.modul3.cinema.service.KartaService;
import com.ftninformatika.jwd.modul3.cinema.service.KorisnikService;
import com.ftninformatika.jwd.modul3.cinema.service.ProjekcijaService;
import com.ftninformatika.jwd.modul3.cinema.service.SedisteService;
import com.ftninformatika.jwd.modul3.cinema.web.dto.KartaDTO;

@Component
public class KartaDtoToKarta implements Converter<KartaDTO, Karta> {

	@Autowired
	private KartaService kartaService;

	@Autowired
	private KorisnikService korisnikService;
	
	@Autowired
	private ProjekcijaService projekcijaService;
	
	@Autowired
	private SedisteService sedisteService;
	
	@Override
	public Karta convert(KartaDTO dto) {
		Karta karta;
		if (dto.getId() != null) {
			karta = kartaService.findOne(dto.getId());
		}else {
			karta = new Karta();
		}
		
		if (karta != null) {
			karta.setDatumIVreme(getLocalDateTime(dto.getDatumIVreme()));
			karta.setKorisnik(korisnikService.findbyKorisnickoIme(dto.getKorisnikUsername()).get());
			karta.setProjekcija(projekcijaService.findOne(dto.getProjekcijaId()));
			karta.setSediste(sedisteService.findOne(dto.getSedisteId()));
		}
		return karta;
	}
	
	private LocalDateTime getLocalDateTime(String datumIVreme) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate datum = LocalDate.parse(datumIVreme.substring(0, 10), formatter);
        LocalTime vreme = LocalTime.parse(datumIVreme.substring(11), DateTimeFormatter.ofPattern("HH:mm"));
        return LocalDateTime.of(datum, vreme);
    }
	
	
}
