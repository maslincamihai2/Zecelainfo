package org.example.zecelainfo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Solutie")
public class Solutie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "idProblema", nullable = false)
    private Problema problema;

    @Column(name = "punctaj", nullable = false)
    private Integer punctaj;

    @Column(name = "cod_sursa", nullable = false, length =10000)
    private String cod_sursa;

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Problema getProblema() {
        return problema;
    }

    public void setProblema(Problema problema) {
        this.problema = problema;
    }

    public Integer getPunctaj() {
        return punctaj;
    }

    public void setPunctaj(Integer punctaj) {
        this.punctaj = punctaj;
    }

    public String getCod_sursa() {
        return cod_sursa;
    }

    public void setCod_sursa(String cod_sursa) {
        this.cod_sursa = cod_sursa;
    }
}

