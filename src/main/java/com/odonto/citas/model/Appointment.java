package com.odonto.citas.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    private String id;

    private String patientId;
    private String dentistId;
    private Long startsAtMillis;
    private String notes;

    public Appointment() {
        if (this.id == null) {
            this.id = UUID.randomUUID().toString();
        }
    }

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

    // --- CORRECCIÓN AQUÍ: Cambiado a getDentistId (inglés) ---
    public String getDentistId() {
        return dentistId;
    }

    public void setDentistId(String dentistId) {
        this.dentistId = dentistId;
    }
    // ---------------------------------------------------------

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