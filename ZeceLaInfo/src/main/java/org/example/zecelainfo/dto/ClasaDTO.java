package org.example.zecelainfo.dto;

import org.example.zecelainfo.models.Clasa;

public class ClasaDTO {
    private String nume;
    private String nivel;
    private String judet;
    private String localitate;
    private String unitateScolara;
    // Getters and setters


    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getJudet() {
        return judet;
    }

    public void setJudet(String judet) {
        this.judet = judet;
    }

    public String getLocalitate() {
        return localitate;
    }

    public void setLocalitate(String localitate) {
        this.localitate = localitate;
    }

    public String getUnitateScolara() {
        return unitateScolara;
    }

    public void setUnitateScolara(String unitateScolara) {
        this.unitateScolara = unitateScolara;
    }
}

