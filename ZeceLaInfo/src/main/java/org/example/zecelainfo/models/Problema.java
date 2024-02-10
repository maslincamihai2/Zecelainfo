package org.example.zecelainfo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Problema")
public class Problema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nume", nullable = false, length = 20)
    private String nume;

    @Column(name = "cerinta", nullable = false, length = 1000)
    private String cerinta;

    @Column(name = "dificultate", nullable = false)
    private String dificultate;

    @Column(name = "categorie", nullable = false)
    private String categorie;

    @Column(name = "subcategorie", nullable = false)
    private String subcategorie;

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCerinta() {
        return cerinta;
    }

    public void setCerinta(String cerinta) {
        this.cerinta = cerinta;
    }

    public String getDificultate() {
        return dificultate;
    }

    public void setDificultate(String dificultate) {
        this.dificultate = dificultate;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getSubcategorie() {
        return subcategorie;
    }

    public void setSubcategorie(String subcategorie) {
        this.subcategorie = subcategorie;
    }
}

