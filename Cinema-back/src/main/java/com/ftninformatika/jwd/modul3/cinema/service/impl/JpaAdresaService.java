package com.ftninformatika.jwd.modul3.cinema.service.impl;

import com.ftninformatika.jwd.modul3.cinema.model.Adresa;
import com.ftninformatika.jwd.modul3.cinema.repository.AdresaRepository;
import com.ftninformatika.jwd.modul3.cinema.service.AdresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JpaAdresaService implements AdresaService {
    @Autowired
    private AdresaRepository adresaRepository;

    @Override
    public Optional<Adresa> findOne(Long id) {
        return adresaRepository.findById(id);
    }

    @Override
    public List<Adresa> findAll() {
        return adresaRepository.findAll();
    }

    @Override
    public Adresa save(Adresa adresa) {
        return adresaRepository.save(adresa);
    }

    @Override
    public void delete(Long id) {
        adresaRepository.deleteById(id);
    }

	@Override
	public Adresa find(String ulica, String broj) {
		
		return adresaRepository.findByUlicaIgnoreCaseContainsAndBroj(ulica, broj);
	}

}
