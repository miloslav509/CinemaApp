package com.ftninformatika.jwd.modul3.cinema.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ftninformatika.jwd.modul3.cinema.model.Karta;
import com.ftninformatika.jwd.modul3.cinema.model.Tip;
import com.ftninformatika.jwd.modul3.cinema.service.KartaService;
import com.ftninformatika.jwd.modul3.cinema.support.KartaDtoToKarta;
import com.ftninformatika.jwd.modul3.cinema.support.KartaToKartaDto;
import com.ftninformatika.jwd.modul3.cinema.web.dto.KartaDTO;
import com.ftninformatika.jwd.modul3.cinema.web.dto.TipDTO;

@RestController
@RequestMapping(value = "/api/karte", produces = MediaType.APPLICATION_JSON_VALUE)
public class KartaController {

	@Autowired
	private KartaService kartaService;
	
	@Autowired
	private KartaDtoToKarta toKarta;
	
	@Autowired
	private KartaToKartaDto toDto;
	
	@GetMapping
	public ResponseEntity<List<KartaDTO>> getAll(){
		List<Karta> karte = kartaService.findAll();
		
		return new ResponseEntity<>(toDto.convert(karte), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<KartaDTO> getOne(@PathVariable Long id){
		Karta karta = kartaService.findOne(id);
		
		if (karta != null) {
			return new ResponseEntity<>(toDto.convert(karta), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KartaDTO> create(@Valid @RequestBody KartaDTO kartaDTO) {
		Karta karta = toKarta.convert(kartaDTO);
		
		Karta sacuvanaKarta = kartaService.save(karta);
		
		return new ResponseEntity<>(toDto.convert(sacuvanaKarta),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		Karta karta = kartaService.delete(id);
		
		if (karta != null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
