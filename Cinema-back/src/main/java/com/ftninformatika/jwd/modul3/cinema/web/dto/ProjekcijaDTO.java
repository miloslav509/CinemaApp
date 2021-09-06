package com.ftninformatika.jwd.modul3.cinema.web.dto;

public class ProjekcijaDTO {

	
    private Long id;

    private String datumIVreme;
    
    private Long filmId;
    
    private String filmNaziv;
    
    private Long salaId;
    
    private String salaNaziv;
    
    private Long tipId;
    
    private String tipNaziv;
    
    private String administratorUsername;
    
    private double cenaKarte;

	public Long getId() {
		return id;
	}

	public String getDatumIVreme() {
		return datumIVreme;
	}

	public void setDatumIVreme(String datumIVreme) {
		this.datumIVreme = datumIVreme;
	}

	public Long getFilmId() {
		return filmId;
	}

	public void setFilmId(Long filmId) {
		this.filmId = filmId;
	}

	public String getFilmNaziv() {
		return filmNaziv;
	}

	public void setFilmNaziv(String filmNaziv) {
		this.filmNaziv = filmNaziv;
	}

	public Long getSalaId() {
		return salaId;
	}

	public void setSalaId(Long salaId) {
		this.salaId = salaId;
	}

	public String getSalaNaziv() {
		return salaNaziv;
	}

	public void setSalaNaziv(String salaNaziv) {
		this.salaNaziv = salaNaziv;
	}

	public Long getTipId() {
		return tipId;
	}

	public void setTipId(Long tipId) {
		this.tipId = tipId;
	}

	public String getTipNaziv() {
		return tipNaziv;
	}

	public void setTipNaziv(String tipNaziv) {
		this.tipNaziv = tipNaziv;
	}

	

	public String getAdministratorUsername() {
		return administratorUsername;
	}

	public void setAdministratorUsername(String administratorUsername) {
		this.administratorUsername = administratorUsername;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getCenaKarte() {
		return cenaKarte;
	}

	public void setCenaKarte(double cenaKarte) {
		this.cenaKarte = cenaKarte;
	}

	
    
    
}
