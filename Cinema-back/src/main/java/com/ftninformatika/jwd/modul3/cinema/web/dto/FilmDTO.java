package com.ftninformatika.jwd.modul3.cinema.web.dto;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class FilmDTO {

	@Positive(message = "Id mora biti pozitivan broj.")
    private Long id;

    @NotBlank(message = "Naziv zanra nije zadat.")
    private String naziv;
    
    private String reziser;
    
    private int trajanje;
    
    private String zemljaPorekla;
    
    private int godinaProizvodnje;
    
    private String opis;
    
    private Map<Long, String> zanrovi = new LinkedHashMap<>();

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

	public String getReziser() {
		return reziser;
	}

	public void setReziser(String reziser) {
		this.reziser = reziser;
	}

	public int getTrajanje() {
		return trajanje;
	}

	public void setTrajanje(int trajanje) {
		this.trajanje = trajanje;
	}

	public String getZemljaPorekla() {
		return zemljaPorekla;
	}

	public void setZemljaPorekla(String zemljaPorekla) {
		this.zemljaPorekla = zemljaPorekla;
	}

	public int getGodinaProizvodnje() {
		return godinaProizvodnje;
	}

	public void setGodinaProizvodnje(int godinaProizvodnje) {
		this.godinaProizvodnje = godinaProizvodnje;
	}


	public Map<Long, String> getZanrovi() {
		return zanrovi;
	}

	public void setZanrovi(Map<Long, String> zanrovi) {
		this.zanrovi = zanrovi;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}
    
    
}
