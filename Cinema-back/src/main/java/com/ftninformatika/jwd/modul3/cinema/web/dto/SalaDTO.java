package com.ftninformatika.jwd.modul3.cinema.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class SalaDTO {

	@Positive(message = "Id mora biti pozitivan broj.")
    private Long id;

    @NotBlank(message = "Naziv zanra nije zadat.")
    private String naziv;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
    
    
}
