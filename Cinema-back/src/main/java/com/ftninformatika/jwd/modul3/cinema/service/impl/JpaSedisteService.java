package com.ftninformatika.jwd.modul3.cinema.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.modul3.cinema.model.Karta;
import com.ftninformatika.jwd.modul3.cinema.model.Projekcija;
import com.ftninformatika.jwd.modul3.cinema.model.Sala;
import com.ftninformatika.jwd.modul3.cinema.model.Sediste;
import com.ftninformatika.jwd.modul3.cinema.repository.SedisteRepository;
import com.ftninformatika.jwd.modul3.cinema.service.ProjekcijaService;
import com.ftninformatika.jwd.modul3.cinema.service.SedisteService;

@Service
public class JpaSedisteService implements SedisteService {

	@Autowired
	private SedisteRepository sedisteRepository;
	
	@Autowired
	private ProjekcijaService projekcijaService;

	@Override
	public List<Sediste> findBySala(Long id) {
		
		return sedisteRepository.findBySalaId(id);
	}

	@Override
	public List<Sediste> findAll() {
		
		return sedisteRepository.findAll();
	}

	@Override
	public Sediste findOne(Long id) {
		
		return sedisteRepository.findById(id).get();
	}

	@Override
	public Sediste save(Sediste sediste) {
		
		return sedisteRepository.save(sediste);
	}

	@Override
	public List<Sediste> findByProjekcija(Long id) {
		Projekcija projekcija = projekcijaService.findOne(id);
		List<Sediste> sedista = projekcija.getSala().getSedista();
		List<Karta> karte = projekcija.getKarte();
		if (karte.size() > 0) {
			for (Karta karta : karte) {
				for (int i = 0; i < sedista.size(); i++) {
					if (sedista.get(i).getId() == karta.getSediste().getId()) {
						sedista.remove(i);
						break;
					} 
				}
			}
		}
		return sedista;
	}
	
	
}
