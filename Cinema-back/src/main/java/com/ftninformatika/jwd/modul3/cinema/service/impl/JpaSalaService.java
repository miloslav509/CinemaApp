package com.ftninformatika.jwd.modul3.cinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.modul3.cinema.model.Sala;
import com.ftninformatika.jwd.modul3.cinema.repository.SalaRepository;
import com.ftninformatika.jwd.modul3.cinema.service.SalaService;

@Service
public class JpaSalaService implements SalaService {

	@Autowired
	private SalaRepository salaRepository;

	@Override
	public List<Sala> findAll() {
		
		return salaRepository.findAll();
	}

	@Override
	public Sala findOne(Long id) {
		
		return salaRepository.findById(id).get();
	}

	@Override
	public List<Sala> findByTip(Long id) {
		
		return salaRepository.findByTipoviId(id);
	}

	@Override
	public Sala save(Sala sala) {
		
		return salaRepository.save(sala);
	};
	
	
}
