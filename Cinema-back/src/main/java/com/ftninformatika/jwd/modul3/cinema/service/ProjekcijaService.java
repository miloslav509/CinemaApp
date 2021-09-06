package com.ftninformatika.jwd.modul3.cinema.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;

import com.ftninformatika.jwd.modul3.cinema.model.Projekcija;

public interface ProjekcijaService {

	Projekcija findOne(Long id);

    List<Projekcija> findAll();

    Projekcija save(Projekcija projekcija);

    Projekcija update(Projekcija projekcija);

    Projekcija delete(Long id);

    Page<Projekcija> find(LocalDateTime datumIVremeOd, LocalDateTime datumIVremeDo, Long filmId, Double cenaKarteOd, Double cenaKarteDo, int PageNo);
    
    List<Projekcija> findByFilmId(Long filmId);
    
    Page<Projekcija> pretraga(Long filmId, LocalDateTime datumIVremeOd, String tip, int pageNum);
}
