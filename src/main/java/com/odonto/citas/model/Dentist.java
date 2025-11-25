package com.odonto.citas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "dentists")
public class Dentist {
    @Id
    private String id;
    private String name;
    private String specialty;

    public Dentist() {
        if (this.id == null) this.id = UUID.randomUUID().toString();
    }

    public Dentist(String name, String specialty) {
        this();
        this.name = name;
        this.specialty = specialty;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }
}