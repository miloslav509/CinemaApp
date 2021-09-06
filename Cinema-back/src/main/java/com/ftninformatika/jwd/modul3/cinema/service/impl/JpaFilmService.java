package com.ftninformatika.jwd.modul3.cinema.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.modul3.cinema.model.Film;
import com.ftninformatika.jwd.modul3.cinema.model.Projekcija;
import com.ftninformatika.jwd.modul3.cinema.repository.FilmRepository;
import com.ftninformatika.jwd.modul3.cinema.service.FilmService;
import com.ftninformatika.jwd.modul3.cinema.service.ProjekcijaService;

@Service
public class JpaFilmService implements FilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private ProjekcijaService projekcijaService;
    
    @Override
    public Film findOne(Long id) {
        return filmRepository.findOneById(id);
    }

    @Override
    public List<Film> findAll() {
        return filmRepository.findAll();
    }

    @Override
    public Film save(Film film) {
        return filmRepository.save(film);
    }

    @Override
    public Film update(Film film) {
        return filmRepository.save(film);
    }

    @Override
    //Kada se obrise film obrisace se i sve projekcije koje su vezane za taj film
    public Film delete(Long id) {
        Film film = findOne(id);
        if(film != null){
        	filmRepository.deleteById(id);
        	return film;
        }
        return null;
    }

    @Override
    public List<Film> find(String naziv, Long zanrId, Integer trajanjeOd, Integer trajanjeDo) {
        if (naziv == null) {
            naziv = "";
        }

        if (trajanjeOd == null) {
            trajanjeOd = 0;
        }

        if (trajanjeDo == null) {
            trajanjeDo = Integer.MAX_VALUE;
        }

        if(zanrId == null){
            return filmRepository.findByNazivIgnoreCaseContainsAndTrajanjeBetween(naziv,trajanjeOd,trajanjeDo);
        }
        return filmRepository.findByNazivIgnoreCaseContainsAndTrajanjeBetweenAndZanroviId(naziv,trajanjeOd,trajanjeDo,zanrId);
    }

    @Override
    public List<Film> findByZanrId(Long zanrId) {
        return filmRepository.findByZanroviId(zanrId);
    }
}
