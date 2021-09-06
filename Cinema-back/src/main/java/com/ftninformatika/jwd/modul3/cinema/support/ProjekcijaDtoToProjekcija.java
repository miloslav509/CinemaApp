package com.ftninformatika.jwd.modul3.cinema.support;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.cinema.model.Projekcija;
import com.ftninformatika.jwd.modul3.cinema.service.FilmService;
import com.ftninformatika.jwd.modul3.cinema.service.KorisnikService;
import com.ftninformatika.jwd.modul3.cinema.service.ProjekcijaService;
import com.ftninformatika.jwd.modul3.cinema.service.SalaService;
import com.ftninformatika.jwd.modul3.cinema.service.TipService;
import com.ftninformatika.jwd.modul3.cinema.web.dto.ProjekcijaDTO;

@Component
public class ProjekcijaDtoToProjekcija implements Converter<ProjekcijaDTO, Projekcija> {

	@Autowired
	private ProjekcijaService projekcijaService;
	
	@Autowired
	private FilmService filmService;
	
	@Autowired
	private SalaService salaService;
	
	@Autowired
	private TipService tipService;
	
	@Autowired
	private KorisnikService korisnikService;

	@Override
	public Projekcija convert(ProjekcijaDTO dto) {
		Projekcija projekcija;
		if (dto.getId() != null) {
			projekcija = projekcijaService.findOne(dto.getId());
		}else {
			projekcija = new Projekcija();
		}
		
		if (projekcija != null) {
			projekcija.setDatumIVreme(getLocalDateTime(dto.getDatumIVreme()));
			projekcija.setFilm(filmService.findOne(dto.getFilmId()));
			projekcija.setSala(salaService.findOne(dto.getSalaId()));
			projekcija.setTip(tipService.findOne(dto.getTipId()));
			projekcija.setAdministrator(korisnikService.findbyKorisnickoIme(dto.getAdministratorUsername()).get());
			projekcija.setCenaKarte(dto.getCenaKarte());
		}
		return projekcija;
	}
	
	private LocalDateTime getLocalDateTime(String datumIVreme) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate datum = LocalDate.parse(datumIVreme.substring(0, 10), formatter);
        LocalTime vreme = LocalTime.parse(datumIVreme.substring(11), DateTimeFormatter.ofPattern("HH:mm"));
        return LocalDateTime.of(datum, vreme);
    }
	
}
