package com.ftninformatika.jwd.modul3.cinema.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Karta {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "datum_vreme")
	private LocalDateTime datumIVreme;
	
	@ManyToOne
	private Projekcija projekcija;
	
	@OneToOne
	private Sediste sediste;
	
	@ManyToOne
	private Korisnik korisnik;

	public Karta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Karta(LocalDateTime datumIVreme, Projekcija projekcija, Sediste sediste, Korisnik korisnik) {
		super();
		this.datumIVreme = datumIVreme;
		this.projekcija = projekcija;
		this.sediste = sediste;
		this.korisnik = korisnik;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datumIVreme == null) ? 0 : datumIVreme.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((korisnik == null) ? 0 : korisnik.hashCode());
		result = prime * result + ((projekcija == null) ? 0 : projekcija.hashCode());
		result = prime * result + ((sediste == null) ? 0 : sediste.hashCode());
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
		Karta other = (Karta) obj;
		if (datumIVreme == null) {
			if (other.datumIVreme != null)
				return false;
		} else if (!datumIVreme.equals(other.datumIVreme))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (korisnik == null) {
			if (other.korisnik != null)
				return false;
		} else if (!korisnik.equals(other.korisnik))
			return false;
		if (projekcija == null) {
			if (other.projekcija != null)
				return false;
		} else if (!projekcija.equals(other.projekcija))
			return false;
		if (sediste == null) {
			if (other.sediste != null)
				return false;
		} else if (!sediste.equals(other.sediste))
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

	public Projekcija getProjekcija() {
		return projekcija;
	}

	public void setProjekcija(Projekcija projekcija) {
		this.projekcija = projekcija;
	}

	public Sediste getSediste() {
		return sediste;
	}

	public void setSediste(Sediste sediste) {
		this.sediste = sediste;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	@Override
	public String toString() {
		return "Karta [id=" + id + ", datumIVreme=" + datumIVreme + ", projekcija=" + projekcija + ", sediste="
				+ sediste + ", korisnik=" + korisnik + "]";
	}
	
	
	
}
