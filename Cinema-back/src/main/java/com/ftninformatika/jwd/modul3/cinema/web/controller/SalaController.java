package com.ftninformatika.jwd.modul3.cinema.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftninformatika.jwd.modul3.cinema.model.Sala;
import com.ftninformatika.jwd.modul3.cinema.model.Sediste;
import com.ftninformatika.jwd.modul3.cinema.model.Tip;
import com.ftninformatika.jwd.modul3.cinema.service.SalaService;
import com.ftninformatika.jwd.modul3.cinema.service.SedisteService;
import com.ftninformatika.jwd.modul3.cinema.support.SalaDtoToSala;
import com.ftninformatika.jwd.modul3.cinema.support.SalaToSalaDto;
import com.ftninformatika.jwd.modul3.cinema.support.SedisteToSedisteDto;
import com.ftninformatika.jwd.modul3.cinema.web.dto.SalaDTO;
import com.ftninformatika.jwd.modul3.cinema.web.dto.SedisteDTO;
import com.ftninformatika.jwd.modul3.cinema.web.dto.TipDTO;

@RestController
@RequestMapping(value = "/api/sale", produces = MediaType.APPLICATION_JSON_VALUE)
public class SalaController {

	@Autowired
	private SalaService salaService;
	
	@Autowired
	private SalaDtoToSala salaDtoToSala;
	
	@Autowired
	private SalaToSalaDto salaToSalaDto;
	
	@Autowired
	private SedisteService sedisteService;
	
	@Autowired
	private SedisteToSedisteDto toSedisteDto;
	
	@GetMapping
	public ResponseEntity<List<SalaDTO>> getAll(){
		List<Sala> sale = salaService.findAll();
		
		return new ResponseEntity<>(salaToSalaDto.convert(sale), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SalaDTO> getOne(@PathVariable Long id){
		Sala sala = salaService.findOne(id);
		
		if (sala != null) {
			return new ResponseEntity<>(salaToSalaDto.convert(sala), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{id}/sedista")
	public ResponseEntity<List<SedisteDTO>> findBySalaId(@PathVariable Long id){
		List<Sediste> sedista = sedisteService.findBySala(id);
		
		return new ResponseEntity<>(toSedisteDto.convert(sedista), HttpStatus.OK);
	}
}
