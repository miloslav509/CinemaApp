package com.ftninformatika.jwd.modul3.cinema.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class AdresaDTO {

    @Positive(message = "Id mora biti pozitivan broj.")
    private Long id;

    @NotBlank(message = "Ulica nije zadata.")
    private String ulica;

    @NotBlank(message = "Broj ulice nije zadat.")
    private String broj;

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
}
