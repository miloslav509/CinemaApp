package com.ftninformatika.jwd.modul3.cinema.model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Adresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String ulica;

    @Column
    private String broj;

    @OneToMany(mappedBy = "adresa", cascade = CascadeType.ALL)
    private List<Korisnik> korisnici = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    public List<Korisnik> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(List<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }

    public void dodajKorisnika(Korisnik korisnik){
        this.korisnici.add(korisnik);
        if (!equals(korisnik.getAdresa())) {
            korisnik.setAdresa(this);
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
        Adresa other = (Adresa) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Adresa [id=" + id + ", ulica=" + ulica + ", broj=" + broj + "]";
    }
}
