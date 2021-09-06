package com.ftninformatika.jwd.modul3.cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftninformatika.jwd.modul3.cinema.model.Zanr;

@Repository
public interface ZanrRepository extends JpaRepository<Zanr, Long> {

	Zanr findOneById(Long id);

    List<Zanr> findByNazivIgnoreCaseContains(String naziv);

    List<Zanr> findByIdIn(List<Long> ids);
    
    List<Zanr> findByFilmoviId(Long id);
}
