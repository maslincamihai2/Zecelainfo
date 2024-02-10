package org.example.zecelainfo.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Tema")
public class Tema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "idClasa", nullable = false)
    private Clasa clasa;

    @Column(name = "nume", nullable = false, length = 20)
    private String nume;

    @Column(name = "descriere", length = 50)
    private String descriere;

    @Column(name = "data_inceput")
    private LocalDate dataInceput;

    @Column(name = "data_sfarsit", nullable = false)
    private LocalDate dataSfarsit;

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Clasa getClasa() {
        return clasa;
    }

    public void setClasa(Clasa clasa) {
        this.clasa = clasa;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public LocalDate getDataInceput() {
        return dataInceput;
    }

    public void setDataInceput(LocalDate dataInceput) {
        this.dataInceput = dataInceput;
    }

    public LocalDate getDataSfarsit() {
        return dataSfarsit;
    }

    public void setDataSfarsit(LocalDate dataSfarsit) {
        this.dataSfarsit = dataSfarsit;
    }
}
