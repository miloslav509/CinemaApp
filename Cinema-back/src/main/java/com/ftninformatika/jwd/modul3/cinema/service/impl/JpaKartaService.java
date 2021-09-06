package com.ftninformatika.jwd.modul3.cinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.modul3.cinema.model.Karta;
import com.ftninformatika.jwd.modul3.cinema.model.Korisnik;
import com.ftninformatika.jwd.modul3.cinema.model.Sediste;
import com.ftninformatika.jwd.modul3.cinema.repository.KartaRepository;
import com.ftninformatika.jwd.modul3.cinema.service.KartaService;
import com.ftninformatika.jwd.modul3.cinema.service.KorisnikService;
import com.ftninformatika.jwd.modul3.cinema.service.ProjekcijaService;
import com.ftninformatika.jwd.modul3.cinema.service.SedisteService;

@Service
public class JpaKartaService implements KartaService {

	@Autowired
	private KartaRepository kartaRepository;
	
	@Autowired
	private KorisnikService korisnikService;
	
	@Autowired
	private ProjekcijaService projekcijaService;
	
	@Autowired
	private SedisteService sedisteService;

	@Override
	public Karta findOne(Long id) {
		
		return kartaRepository.findById(id).get();
	}

	@Override
	public List<Karta> findAll() {
		
		return kartaRepository.findAll();
	}

	@Override
	public Karta save(Karta karta) {
//		Sediste sediste = karta.getSediste();
//		sediste.setKarta(karta);
//		sedisteService.save(sediste);
		return kartaRepository.save(karta);
	}

	@Override
	public Karta delete(Long id) {
		Karta karta = findOne(id);
		if (karta != null) {
//			if (karta.getKorisnik() != null) {
//				
//				Korisnik korisnik = karta.getKorisnik();
//				korisnik.getKarte().remove(karta);
//				korisnikService.save(korisnik);
//				karta.setKorisnik(null);
//			}
//			Sediste sediste = karta.getSediste();
//			sediste.setKarta(null);
//			sedisteService.save(sediste);
//			karta.setSediste(null);
//			if (karta.getProjekcija() != null) {
//				karta.getProjekcija().getKarte().remove(karta);
//			}
//			
			
			kartaRepository.deleteById(id);
			return karta;
			
		}
		return null;
	}

	@Override
	public List<Karta> findByKorisnik(Long id) {
		
		return kartaRepository.findByKorisnikId(id);
	}
	
	
}
