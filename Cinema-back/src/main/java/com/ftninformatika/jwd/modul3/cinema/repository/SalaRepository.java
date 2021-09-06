package com.ftninformatika.jwd.modul3.cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftninformatika.jwd.modul3.cinema.model.Sala;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {

	List<Sala> findByTipoviId (Long id);
	
	
}
