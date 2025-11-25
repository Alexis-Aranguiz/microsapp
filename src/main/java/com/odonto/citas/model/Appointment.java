package com.odonto.citas.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    private String id; // Usamos String para UUIDs generados por la app o backend

    private String patientId;
    private String dentistId;
    private Long startsAtMillis; // Coincide con el Long de Android
    private String notes;

    public Appointment() {
        // Si el ID viene nulo, generamos uno.
        if (this.id == null) {
            this.id = UUID.randomUUID().toString();
        }
    }

    // Constructor, Getters y Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDentistaId() {
        return dentistId;
    }

    public void setDentistaId(String dentistId) {
        this.dentistId = dentistId;
    }

    public Long getStartsAtMillis() {
        return startsAtMillis;
    }

    public void setStartsAtMillis(Long startsAtMillis) {
        this.startsAtMillis = startsAtMillis;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}