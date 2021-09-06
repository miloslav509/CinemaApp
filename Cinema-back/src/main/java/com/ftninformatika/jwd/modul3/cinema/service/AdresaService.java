package com.ftninformatika.jwd.modul3.cinema.service;

import com.ftninformatika.jwd.modul3.cinema.model.Adresa;

import java.util.List;
import java.util.Optional;

public interface AdresaService {

    Optional<Adresa> findOne(Long id);

    List<Adresa> findAll();

    Adresa save(Adresa adresa);

    void delete(Long id);
    
    Adresa find(String ulica, String broj);

}
