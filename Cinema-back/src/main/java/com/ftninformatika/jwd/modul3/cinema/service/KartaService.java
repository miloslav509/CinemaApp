package com.ftninformatika.jwd.modul3.cinema.service;

import java.util.List;

import com.ftninformatika.jwd.modul3.cinema.model.Karta;

public interface KartaService {

	Karta findOne(Long id);
	
	List<Karta> findAll();
	
	Karta save(Karta karta);
	
	Karta delete(Long id);
	
	List<Karta> findByKorisnik(Long id);
}
