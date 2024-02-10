package org.example.zecelainfo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "TemaProblema")
public class TemaProblema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idTema", nullable = false)
    private Tema tema;

    @ManyToOne
    @JoinColumn(name = "idProblema", nullable = false)
    private Problema problema;

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public Problema getProblema() {
        return problema;
    }

    public void setProblema(Problema problema) {
        this.problema = problema;
    }
}
