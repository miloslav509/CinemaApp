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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Sala {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column
	private String naziv;
	
	@ManyToMany(mappedBy = "sale", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Tip> tipovi = new HashSet<>();
	
	@OneToMany(mappedBy = "sala", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Sediste> sedista = new ArrayList<>();
	
	@OneToMany(mappedBy = "sala", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Projekcija> projekcije = new ArrayList<>();

	public Sala(String naziv) {
		super();
		this.naziv = naziv;
	}

	public Sala() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
		result = prime * result + ((tipovi == null) ? 0 : tipovi.hashCode());
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
		Sala other = (Sala) obj;
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
		if (tipovi == null) {
			if (other.tipovi != null)
				return false;
		} else if (!tipovi.equals(other.tipovi))
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

	public Set<Tip> getTipovi() {
		return tipovi;
	}

	public void setTipovi(Set<Tip> tipovi) {
		this.tipovi = tipovi;
	}
	
	

	public List<Sediste> getSedista() {
		return sedista;
	}

	public void setSedista(List<Sediste> sedista) {
		this.sedista = sedista;
	}
	
	

	public List<Projekcija> getProjekcije() {
		return projekcije;
	}

	public void setProjekcije(List<Projekcija> projekcije) {
		this.projekcije = projekcije;
	}

	@Override
	public String toString() {
		return "Sala [id=" + id + ", naziv=" + naziv + ", tipovi=" + tipovi + "]";
	}
	
	
	
	
	
	
}
