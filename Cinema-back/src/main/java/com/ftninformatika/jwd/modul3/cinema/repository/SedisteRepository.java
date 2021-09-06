package com.ftninformatika.jwd.modul3.cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftninformatika.jwd.modul3.cinema.model.Sediste;

@Repository
public interface SedisteRepository extends JpaRepository<Sediste, Long> {

	List<Sediste> findBySalaId (Long id);
}
