package com.ftninformatika.jwd.modul3.cinema.model;

import com.ftninformatika.jwd.modul3.cinema.enumeration.KorisnickaUloga;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Korisnik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String korisnickoIme;

    @Column( unique = true, nullable = false)
    private String eMail;

    @Column
    private String ime;

    @Column
    private String prezime;

    @Column(nullable = false)
    private String lozinka;

    @Enumerated(EnumType.STRING)
    private KorisnickaUloga uloga;

    @ManyToOne
    private Adresa adresa;
    
    @OneToMany(mappedBy = "administrator", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Projekcija> projekcije = new ArrayList<>();
    
    @OneToMany(mappedBy = "korisnik", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Karta> karte = new ArrayList<>();
    

    public Korisnik(){

    }

    public Korisnik(String korisnickoIme, String eMail, String ime, String prezime, String lozinka, KorisnickaUloga uloga) {
        this.korisnickoIme = korisnickoIme;
        this.eMail = eMail;
        this.ime = ime;
        this.prezime = prezime;
        this.lozinka = lozinka;
        this.uloga = uloga;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public KorisnickaUloga getUloga() {
        return uloga;
    }

    public void setUloga(KorisnickaUloga uloga) {
        this.uloga = uloga;
    }

    public Adresa getAdresa() {
        return adresa;
    }
    
    

    public List<Projekcija> getProjekcije() {
		return projekcije;
	}

	public void setProjekcije(List<Projekcija> projekcije) {
		this.projekcije = projekcije;
	}

	public List<Karta> getKarte() {
		return karte;
	}

	public void setKarte(List<Karta> karte) {
		this.karte = karte;
	}

	public void setAdresa(Adresa adresa) {
        this.adresa = adresa;
        if (adresa != null && !adresa.getKorisnici().contains(this)) {
           adresa.getKorisnici().add(this);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Korisnik other = (Korisnik) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Korisnik [id=" + id + ", ime=" + ime + ", prezime=" + prezime + "]";
    }

}
