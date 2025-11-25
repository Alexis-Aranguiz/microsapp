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
        if (cita.getId() == null || cita.getId().isEmpty()) {
            cita.setId(UUID.randomUUID().toString());
        }
        return repo.save(cita);
    }

    public List<Appointment> listar() {
        return repo.findAll();
    }

    public void eliminar(String id) {
        repo.deleteById(id);
    }

    // 👇 NUEVO: Método para actualizar
    public Appointment actualizar(String id, Appointment datosNuevos) {
        return repo.findById(id).map(cita -> {
            cita.setNotes(datosNuevos.getNotes());
            // Si quisieras editar fecha/hora, aquí agregarías:
            // cita.setStartsAtMillis(datosNuevos.getStartsAtMillis());
            return repo.save(cita);
        }).orElse(null);
    }
}