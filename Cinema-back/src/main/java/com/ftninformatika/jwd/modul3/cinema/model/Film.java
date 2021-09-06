package com.ftninformatika.jwd.modul3.cinema.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Film {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column
	private String naziv;
	
	@Column
	private String reziser;
	
	@Column
	private int trajanje;
	
	@Column
	private String zemljaPorekla;
	
	@Column
	private int godinaProizvodnje;
	
	@ManyToMany
    @JoinTable(name = "film_zanr", joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "id"),
    			inverseJoinColumns = @JoinColumn(name = "zanr_id", referencedColumnName = "id"))
    private Set<Zanr> zanrovi = new HashSet<>();
	
	@OneToMany(mappedBy = "film", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Projekcija> projekcije = new ArrayList<>();
	
	@Column
	private String opis;

	public Film() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Film(String naziv, String reziser, int trajanje, String zemljaPorekla, int godinaProizvodnje, String opis) {
		super();
		this.naziv = naziv;
		this.reziser = reziser;
		this.trajanje = trajanje;
		this.zemljaPorekla = zemljaPorekla;
		this.godinaProizvodnje = godinaProizvodnje;
		this.opis = opis;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + godinaProizvodnje;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
		result = prime * result + ((opis == null) ? 0 : opis.hashCode());
		result = prime * result + ((reziser == null) ? 0 : reziser.hashCode());
		result = prime * result + trajanje;
		result = prime * result + ((zanrovi == null) ? 0 : zanrovi.hashCode());
		result = prime * result + ((zemljaPorekla == null) ? 0 : zemljaPorekla.hashCode());
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
		Film other = (Film) obj;
		if (godinaProizvodnje != other.godinaProizvodnje)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (naziv == null) {
			if (other.naziv != null)
				return false;
		} else if (!naziv.equals(other.naziv))
			return false;
		if (opis == null) {
			if (other.opis != null)
				return false;
		} else if (!opis.equals(other.opis))
			return false;
		if (reziser == null) {
			if (other.reziser != null)
				return false;
		} else if (!reziser.equals(other.reziser))
			return false;
		if (trajanje != other.trajanje)
			return false;
		if (zanrovi == null) {
			if (other.zanrovi != null)
				return false;
		} else if (!zanrovi.equals(other.zanrovi))
			return false;
		if (zemljaPorekla == null) {
			if (other.zemljaPorekla != null)
				return false;
		} else if (!zemljaPorekla.equals(other.zemljaPorekla))
			return false;
		return true;
	}

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

	public Set<Zanr> getZanrovi() {
		return zanrovi;
	}

	public void setZanrovi(Set<Zanr> zanrovi) {
		this.zanrovi = zanrovi;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	

	public List<Projekcija> getProjekcije() {
		return projekcije;
	}

	public void setProjekcije(List<Projekcija> projekcije) {
		this.projekcije = projekcije;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", naziv=" + naziv + ", reziser=" + reziser + ", trajanje=" + trajanje
				+ ", zemljaPorekla=" + zemljaPorekla + ", godinaProizvodnje=" + godinaProizvodnje + ", zanrovi="
				+ zanrovi + ", opis=" + opis + "]";
	}
	
	
	
}
