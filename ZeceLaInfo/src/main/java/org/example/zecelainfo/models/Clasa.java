package org.example.zecelainfo.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Clasa")
public class Clasa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nume", nullable = false, length = 20)
    private String nume;

    @Column(name = "nivel", nullable = false)
    private String nivel;

    @Column(name = "judet", nullable = false, length = 20)
    private String judet;

    @Column(name = "localitate", nullable = false, length = 20)
    private String localitate;

    @Column(name = "unitate_scolara", nullable = false, length = 40)
    private String unitateScolara;

    @OneToMany(mappedBy = "clasa", cascade = CascadeType.REMOVE)
    private List<UserClasa> userClasas;


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
