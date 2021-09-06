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

import com.ftninformatika.jwd.modul3.cinema.model.Sediste;
import com.ftninformatika.jwd.modul3.cinema.model.Tip;
import com.ftninformatika.jwd.modul3.cinema.service.SedisteService;
import com.ftninformatika.jwd.modul3.cinema.support.SedisteDtoToSediste;
import com.ftninformatika.jwd.modul3.cinema.support.SedisteToSedisteDto;
import com.ftninformatika.jwd.modul3.cinema.web.dto.SedisteDTO;
import com.ftninformatika.jwd.modul3.cinema.web.dto.TipDTO;

@RestController
@RequestMapping(value = "/api/sedista", produces = MediaType.APPLICATION_JSON_VALUE)
public class SedisteController {

	@Autowired
	private SedisteService sedisteService;
	
	@Autowired
	private SedisteToSedisteDto toDto;
	
	@Autowired
	private  SedisteDtoToSediste toSediste;
	
	@GetMapping
	public ResponseEntity<List<SedisteDTO>> getAll(){
		List<Sediste> sedista = sedisteService.findAll();
		
		return new ResponseEntity<>(toDto.convert(sedista), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SedisteDTO> getOne(@PathVariable Long id){
		Sediste sediste = sedisteService.findOne(id);
		
		if (sediste != null) {
			return new ResponseEntity<>(toDto.convert(sediste), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
