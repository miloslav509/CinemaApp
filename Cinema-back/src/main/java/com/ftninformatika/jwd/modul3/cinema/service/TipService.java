package com.ftninformatika.jwd.modul3.cinema.service;

import java.util.List;

import com.ftninformatika.jwd.modul3.cinema.model.Tip;

public interface TipService {

	List<Tip> findBySala (Long id);
	
	List<Tip> findAll();
	
	Tip findOne(Long id);
	
	Tip save(Tip tip);
}
