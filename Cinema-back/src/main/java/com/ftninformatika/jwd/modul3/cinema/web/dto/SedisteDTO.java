package com.ftninformatika.jwd.modul3.cinema.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class SedisteDTO {

	@Positive(message = "Id mora biti pozitivan broj.")
    private Long id;

    @NotBlank(message = "Redni broj nije zadat.")
    private int redniBroj;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRedniBroj() {
		return redniBroj;
	}

	public void setRedniBroj(int redniBroj) {
		this.redniBroj = redniBroj;
	}
    
    
    
}
