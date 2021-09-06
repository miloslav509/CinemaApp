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
import com.ftninformatika.jwd.modul3.cinema.model.Tip;
import com.ftninformatika.jwd.modul3.cinema.service.SalaService;
import com.ftninformatika.jwd.modul3.cinema.service.TipService;
import com.ftninformatika.jwd.modul3.cinema.support.SalaToSalaDto;
import com.ftninformatika.jwd.modul3.cinema.support.TipDtoToTip;
import com.ftninformatika.jwd.modul3.cinema.support.TipToTipDto;
import com.ftninformatika.jwd.modul3.cinema.web.dto.SalaDTO;
import com.ftninformatika.jwd.modul3.cinema.web.dto.TipDTO;

@RestController
@RequestMapping(value = "/api/tipovi", produces = MediaType.APPLICATION_JSON_VALUE)
public class TipController {

	@Autowired
	private TipService tipService;
	
	@Autowired
	private TipDtoToTip toTip;
	
	@Autowired
	private TipToTipDto toDto;
	
	@Autowired
	private SalaService salaService;
	
	@Autowired
	private SalaToSalaDto toSalaDto;
	
	@GetMapping
	public ResponseEntity<List<TipDTO>> getAll(){
		List<Tip> tipovi = tipService.findAll();
		
		return new ResponseEntity<>(toDto.convert(tipovi), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TipDTO> getOne(@PathVariable Long id){
		Tip tip = tipService.findOne(id);
		
		if (tip != null) {
			return new ResponseEntity<>(toDto.convert(tip), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{id}/sale")
	public ResponseEntity<List<SalaDTO>> findByTipId(@PathVariable Long id){
		List<Sala> sale = salaService.findByTip(id);
		
		return new ResponseEntity<>(toSalaDto.convert(sale), HttpStatus.OK);
	}
	
}
