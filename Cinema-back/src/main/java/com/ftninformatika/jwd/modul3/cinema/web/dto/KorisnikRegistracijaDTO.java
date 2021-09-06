package com.ftninformatika.jwd.modul3.cinema.web.dto;

import javax.validation.constraints.NotBlank;

public class KorisnikRegistracijaDTO extends KorisnikDTO{

    @NotBlank(message = "Lozinka nije zadata.")
    private String lozinka;

    @NotBlank(message = "Ponovljena lozinka nije zadata.")
    private String ponovljenaLozinka;

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getPonovljenaLozinka() {
        return ponovljenaLozinka;
    }

    public void setPonovljenaLozinka(String ponovljenaLozinka) {
        this.ponovljenaLozinka = ponovljenaLozinka;
    }
}
