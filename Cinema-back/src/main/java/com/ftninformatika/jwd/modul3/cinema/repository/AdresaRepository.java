package com.ftninformatika.jwd.modul3.cinema.repository;

import com.ftninformatika.jwd.modul3.cinema.model.Adresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdresaRepository extends JpaRepository<Adresa, Long> {

	Adresa findByUlicaIgnoreCaseContainsAndBroj (String ulica, String broj);
}
