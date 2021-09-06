package com.ftninformatika.jwd.modul3.cinema.service;

import java.util.List;

import com.ftninformatika.jwd.modul3.cinema.model.Sediste;

public interface SedisteService {

	List<Sediste> findBySala (Long id);
	
	List<Sediste> findAll();
	
	Sediste findOne(Long id);
	
	Sediste save(Sediste sediste);
	
	List<Sediste> findByProjekcija(Long id);
}
