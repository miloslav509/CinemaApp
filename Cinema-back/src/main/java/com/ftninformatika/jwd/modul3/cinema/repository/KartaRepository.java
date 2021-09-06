package com.ftninformatika.jwd.modul3.cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftninformatika.jwd.modul3.cinema.model.Karta;

@Repository
public interface KartaRepository extends JpaRepository<Karta, Long> {

	List<Karta> findByKorisnikId(Long id);
}
