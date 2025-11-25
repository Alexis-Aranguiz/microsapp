package com.odonto.citas.controller;

import com.odonto.citas.model.Appointment;
import com.odonto.citas.service.AppointmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*") // Permite peticiones desde cualquier origen (Android)
@RestController
// Ruta en inglés para coincidir con Android retrofit
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService service;

    public AppointmentController(AppointmentService service) {
        this.service = service;
    }

    // Crear cita (POST /appointments)
    @PostMapping
    public Appointment crear(@RequestBody Appointment cita) {
        return service.crear(cita);
    }

    // Listar todas las citas (GET /appointments)
    @GetMapping
    public List<Appointment> listar() {
        return service.listar();
    }
}