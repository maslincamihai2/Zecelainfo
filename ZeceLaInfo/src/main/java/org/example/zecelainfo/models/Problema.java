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

    @Enumerated(EnumType.STRING)
    @Column(name = "dificultate", nullable = false)
    private Dificultate dificultate;

    @Enumerated(EnumType.STRING)
    @Column(name = "categorie", nullable = false)
    private Categorie categorie;

    @Enumerated(EnumType.STRING)
    @Column(name = "subcategorie", nullable = false)
    private Subcategorie subcategorie;

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

    public Dificultate getDificultate() {
        return dificultate;
    }

    public void setDificultate(Dificultate dificultate) {
        this.dificultate = dificultate;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Subcategorie getSubcategorie() {
        return subcategorie;
    }

    public void setSubcategorie(Subcategorie subcategorie) {
        this.subcategorie = subcategorie;
    }

    public enum Dificultate {
        USOARA, MEDIE, DIFICILA, CONCURS
    }

    public enum Categorie {
        ALGORITMI_ELEMENTARI, SUBPROGRAME, RECURSIVITATE
    }

    public enum Subcategorie {
        PROBLEME_DIVERSE, DIVIZIBILITATE, SUBPROGRAME_CU_SIRURI_DE_CARACTERE, SUBPROGRAME_RECURSIVE
    }
}

