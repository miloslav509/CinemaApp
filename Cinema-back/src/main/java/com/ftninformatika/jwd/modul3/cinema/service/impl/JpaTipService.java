package com.ftninformatika.jwd.modul3.cinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.modul3.cinema.model.Tip;
import com.ftninformatika.jwd.modul3.cinema.repository.TipRepository;
import com.ftninformatika.jwd.modul3.cinema.service.TipService;

@Service
public class JpaTipService implements TipService {

	@Autowired
	private TipRepository tipRepository;

	@Override
	public List<Tip> findBySala(Long id) {
		
		return tipRepository.findBySaleId(id);
	}

	@Override
	public List<Tip> findAll() {
		
		return tipRepository.findAll();
	}

	@Override
	public Tip findOne(Long id) {
		
		return tipRepository.findById(id).get();
	}

	@Override
	public Tip save(Tip tip) {
		
		return tipRepository.save(tip);
	}
	
	
}
