package com.ftninformatika.jwd.modul3.cinema.service;

import java.util.List;

import com.ftninformatika.jwd.modul3.cinema.model.Sala;

public interface SalaService {

	List<Sala> findAll();
	
	Sala findOne(Long id); 
	
	List<Sala> findByTip(Long id);
	
	Sala save(Sala sala);
}
