package com.ftninformatika.jwd.modul3.cinema.web.dto;

import javax.validation.constraints.Positive;

public class KartaDTO {

	@Positive(message = "Id mora biti pozitivan broj.")
    private Long id;

    private String datumIVreme;
    
    private String filmNaziv;
    
    private Long projekcijaId;
    
    private String projekcijaVreme;
    
    private Long sedisteId;
    
    private int sedisteBroj;
    
    private String salaNaziv;
    
    private String korisnikUsername;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	public String getProjekcijaVreme() {
		return projekcijaVreme;
	}

	public void setProjekcijaVreme(String projekcijaVreme) {
		this.projekcijaVreme = projekcijaVreme;
	}

	public String getDatumIVreme() {
		return datumIVreme;
	}

	public void setDatumIVreme(String datumIVreme) {
		this.datumIVreme = datumIVreme;
	}

	public String getFilmNaziv() {
		return filmNaziv;
	}

	public void setFilmNaziv(String filmNaziv) {
		this.filmNaziv = filmNaziv;
	}

	public Long getProjekcijaId() {
		return projekcijaId;
	}

	public void setProjekcijaId(Long projekcijaId) {
		this.projekcijaId = projekcijaId;
	}

	public Long getSedisteId() {
		return sedisteId;
	}

	public void setSedisteId(Long sedisteId) {
		this.sedisteId = sedisteId;
	}

	public int getSedisteBroj() {
		return sedisteBroj;
	}

	public void setSedisteBroj(int sedisteBroj) {
		this.sedisteBroj = sedisteBroj;
	}

	public String getKorisnikUsername() {
		return korisnikUsername;
	}

	public void setKorisnikUsername(String korisnikUsername) {
		this.korisnikUsername = korisnikUsername;
	}

	public String getSalaNaziv() {
		return salaNaziv;
	}

	public void setSalaNaziv(String salaNaziv) {
		this.salaNaziv = salaNaziv;
	}

	
	

	
    
    
    
}
