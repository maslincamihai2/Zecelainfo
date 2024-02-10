package org.example.zecelainfo.dto;

public class SolutieDTO {
    private Integer idUser;
    private Integer idProblema;
    private Integer punctaj;
    private String codSursa;
    // Getters and setters


    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdProblema() {
        return idProblema;
    }

    public void setIdProblema(Integer idProblema) {
        this.idProblema = idProblema;
    }

    public Integer getPunctaj() {
        return punctaj;
    }

    public void setPunctaj(Integer punctaj) {
        this.punctaj = punctaj;
    }

    public String getCodSursa() {
        return codSursa;
    }

    public void setCodSursa(String codSursa) {
        this.codSursa = codSursa;
    }
}

