package com.ftninformatika.jwd.modul3.cinema.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Projekcija {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "datum_vreme", nullable = false)
	private LocalDateTime datumIVreme;
	
	@Column
	private double cenaKarte;
	
	@ManyToOne
	private Film film;
	
	@ManyToOne 
	private Tip tip;
	
	@ManyToOne 
	private Sala sala;
	
	@ManyToOne
	private Korisnik administrator;
	
	@OneToMany(mappedBy = "projekcija", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Karta> karte = new ArrayList<>();

	public Projekcija() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Projekcija(LocalDateTime datumIVreme, Film film, Tip tip, Sala sala, Korisnik administrator, double cenaKarte) {
		super();
		this.datumIVreme = datumIVreme;
		this.film = film;
		this.tip = tip;
		this.sala = sala;
		this.administrator = administrator;
		this.cenaKarte = cenaKarte;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((administrator == null) ? 0 : administrator.hashCode());
		long temp;
		temp = Double.doubleToLongBits(cenaKarte);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((datumIVreme == null) ? 0 : datumIVreme.hashCode());
		result = prime * result + ((film == null) ? 0 : film.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((karte == null) ? 0 : karte.hashCode());
		result = prime * result + ((sala == null) ? 0 : sala.hashCode());
		result = prime * result + ((tip == null) ? 0 : tip.hashCode());
		return result;
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Projekcija other = (Projekcija) obj;
		if (administrator == null) {
			if (other.administrator != null)
				return false;
		} else if (!administrator.equals(other.administrator))
			return false;
		if (Double.doubleToLongBits(cenaKarte) != Double.doubleToLongBits(other.cenaKarte))
			return false;
		if (datumIVreme == null) {
			if (other.datumIVreme != null)
				return false;
		} else if (!datumIVreme.equals(other.datumIVreme))
			return false;
		if (film == null) {
			if (other.film != null)
				return false;
		} else if (!film.equals(other.film))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (karte == null) {
			if (other.karte != null)
				return false;
		} else if (!karte.equals(other.karte))
			return false;
		if (sala == null) {
			if (other.sala != null)
				return false;
		} else if (!sala.equals(other.sala))
			return false;
		if (tip == null) {
			if (other.tip != null)
				return false;
		} else if (!tip.equals(other.tip))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDatumIVreme() {
		return datumIVreme;
	}

	public void setDatumIVreme(LocalDateTime datumIVreme) {
		this.datumIVreme = datumIVreme;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Tip getTip() {
		return tip;
	}

	public void setTip(Tip tip) {
		this.tip = tip;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Korisnik getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Korisnik administrator) {
		this.administrator = administrator;
	}

	public List<Karta> getKarte() {
		return karte;
	}

	public void setKarte(List<Karta> karte) {
		this.karte = karte;
	}

	public double getCenaKarte() {
		return cenaKarte;
	}

	public void setCenaKarte(double cenaKarte) {
		this.cenaKarte = cenaKarte;
	}

	@Override
	public String toString() {
		return "Projekcija [id=" + id + ", datumIVreme=" + datumIVreme + ", cenaKarte=" + cenaKarte + ", film=" + film
				+ ", tip=" + tip + ", sala=" + sala + ", administrator=" + administrator + ", karte=" + karte + "]";
	}

	
	
	
	
}
