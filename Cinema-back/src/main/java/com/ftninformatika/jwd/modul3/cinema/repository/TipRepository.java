package com.ftninformatika.jwd.modul3.cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftninformatika.jwd.modul3.cinema.model.Tip;

@Repository
public interface TipRepository extends JpaRepository<Tip, Long> {

	List<Tip> findBySaleId(Long id);
}
