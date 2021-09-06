package com.ftninformatika.jwd.modul3.cinema.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.modul3.cinema.model.Film;
import com.ftninformatika.jwd.modul3.cinema.model.Karta;
import com.ftninformatika.jwd.modul3.cinema.model.Korisnik;
import com.ftninformatika.jwd.modul3.cinema.model.Projekcija;
import com.ftninformatika.jwd.modul3.cinema.model.Sala;
import com.ftninformatika.jwd.modul3.cinema.model.Tip;
import com.ftninformatika.jwd.modul3.cinema.repository.ProjekcijaRepository;
import com.ftninformatika.jwd.modul3.cinema.service.FilmService;
import com.ftninformatika.jwd.modul3.cinema.service.KartaService;
import com.ftninformatika.jwd.modul3.cinema.service.KorisnikService;
import com.ftninformatika.jwd.modul3.cinema.service.ProjekcijaService;
import com.ftninformatika.jwd.modul3.cinema.service.SalaService;
import com.ftninformatika.jwd.modul3.cinema.service.TipService;

@Service
public class JpaProjekcijaService implements ProjekcijaService {

    @Autowired
    private ProjekcijaRepository projekcijaRepository;

    
    @Override
    public Projekcija findOne(Long id) {
        return projekcijaRepository.findOneById(id);
    }

    @Override
    public List<Projekcija> findAll() {
        return projekcijaRepository.findAll();
    }

    @Override
    public Projekcija save(Projekcija projekcija) {
        return projekcijaRepository.save(projekcija);
    }

    @Override
    public Projekcija update(Projekcija projekcija) {
        return projekcijaRepository.save(projekcija);
    }

    @Override
    public Projekcija delete(Long id) {
        Projekcija projekcija = findOne(id);
        if(projekcija != null){
//       	if (projekcija.getFilm() != null) {
//        		projekcija.getFilm().getProjekcije().remove(projekcija);
//                projekcija.setFilm(null);
//			}
//            
//            projekcija.getSala().getProjekcije().remove(projekcija);
//            projekcija.setSala(null);
//            projekcija.getTip().getProjekcije().remove(projekcija);
//            projekcija.setTip(null);
//            for (Karta karta : projekcija.getKarte()) {
//            	karta.setProjekcija(null);
//				kartaService.delete(karta.getId());
//			}
//            projekcija.setKarte(null);
//            projekcija = projekcijaRepository.save(projekcija);
//            projekcijaRepository.delete(projekcija);
        	
            projekcijaRepository.deleteById(id);
        	return projekcija;
        }
        return null;
    }

    

    @Override
    public List<Projekcija> findByFilmId(Long filmId) {
        return projekcijaRepository.findByFilmId(filmId);
    }

    private LocalDateTime getDateConverted(String dateTime) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(dateTime, formatter);
    }

	@Override
	public Page<Projekcija> pretraga(Long filmId, LocalDateTime datumIVremeOd, String tip, int pageNum) {
		
		return null;
	}

	@Override
	public Page<Projekcija> find(LocalDateTime datumIVremeOd, LocalDateTime datumIVremeDo, Long filmId,
			Double cenaKarteOd, Double cenaKarteDo, int PageNo) {
		// TODO Auto-generated method stub
		return projekcijaRepository.search(filmId, datumIVremeOd, datumIVremeDo, cenaKarteOd, cenaKarteDo, PageRequest.of(PageNo, 3));
	}
}