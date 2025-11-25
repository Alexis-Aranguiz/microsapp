package com.odonto.citas.service;

import com.odonto.citas.model.Appointment;
import com.odonto.citas.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AppointmentService {

    private final AppointmentRepository repo;

    public AppointmentService(AppointmentRepository repo) {
        this.repo = repo;
    }

    public Appointment crear(Appointment cita) {
        // Aseguramos que tenga ID si no trae uno
        if (cita.getId() == null || cita.getId().isEmpty()) {
            cita.setId(UUID.randomUUID().toString());
        }
        return repo.save(cita);
    }

    public List<Appointment> listar() {
        return repo.findAll();
    }
}