package com.odonto.citas.model;

import jakarta.persistence.*;

@Entity
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pacienteNombre;
    private String dentistaId;
    private String fecha;  // ej: "2025-11-20"
    private String hora;   // ej: "15:30"
    private String comentario;

    public Cita() {
    }

    public Cita(String pacienteNombre, String dentistaId, String fecha, String hora, String comentario) {
        this.pacienteNombre = pacienteNombre;
        this.dentistaId = dentistaId;
        this.fecha = fecha;
        this.hora = hora;
        this.comentario = comentario;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public String getPacienteNombre() {
        return pacienteNombre;
    }

    public void setPacienteNombre(String pacienteNombre) {
        this.pacienteNombre = pacienteNombre;
    }

    public String getDentistaId() {
        return dentistaId;
    }

    public void setDentistaId(String dentistaId) {
        this.dentistaId = dentistaId;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
