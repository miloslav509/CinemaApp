package com.ftninformatika.jwd.modul3.cinema.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.modul3.cinema.model.Zanr;
import com.ftninformatika.jwd.modul3.cinema.repository.ZanrRepository;
import com.ftninformatika.jwd.modul3.cinema.service.ZanrService;



@Service
public class JpaZanrService implements ZanrService {

    @Autowired
    private ZanrRepository zanrRepository;

    @Override
    public Zanr findOne(Long id) {
        return zanrRepository.findOneById(id);
    }

    @Override
    public List<Zanr> findAll() {
        return zanrRepository.findAll();
    }

    @Override
    public List<Zanr> find(List<Long> ids) {
        return zanrRepository.findByIdIn(ids);
    }

    @Override
    public Zanr save(Zanr zanr) {
        return zanrRepository.save(zanr);
    }

    @Override
    public Zanr update(Zanr zanr) {
        return zanrRepository.save(zanr);
    }

    @Override
    public Zanr delete(Long id) {
        Optional<Zanr> zanr = zanrRepository.findById(id);
        if(zanr.isPresent()){
            zanrRepository.deleteById(id);
            return zanr.get();
        }
        return null;
    }

    @Override
    public List<Zanr> find(String naziv) {
        return zanrRepository.findByNazivIgnoreCaseContains(naziv);
    }

	@Override
	public List<Zanr> findByFilm(Long id) {
		
		return zanrRepository.findByFilmoviId(id);
	}

	
}
