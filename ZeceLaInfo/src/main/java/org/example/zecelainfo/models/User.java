package org.example.zecelainfo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "`User`") // Use backticks for table names that are reserved words or otherwise require quoting
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email", nullable = false, unique = true, length = 254)
    private String email;

    @Column(name = "parola", nullable = false, length = 72)
    private String parola; // Consider renaming to 'password' for clarity

    @Column(name = "nume", nullable = false, length = 20)
    private String nume; // Consider renaming to 'lastName' for clarity

    @Column(name = "prenume", nullable = false, length = 20)
    private String prenume; // Consider renaming to 'firstName' for clarity

    @Enumerated(EnumType.STRING) // Store enum values as strings in the database
    @Column(name = "rol", columnDefinition = "ENUM('elev', 'profesor', 'admin') DEFAULT 'elev'")
    private Role rol; // Consider using an Enum type for roles

    // Default constructor
    public User() {
    }

    // Constructor with parameters
    public User(String email, String parola, String nume, String prenume, Role rol) {
        this.email = email;
        this.parola = parola;
        this.nume = nume;
        this.prenume = prenume;
        this.rol = rol;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public Role getRol() {
        return rol;
    }

    public void setRol(Role rol) {
        this.rol = rol;
    }

    // Enum for user roles
    public enum Role {
        elev, profesor, admin
    }

    // Optionally, override toString(), equals(), and hashCode() methods
}
