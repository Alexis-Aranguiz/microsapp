package com.odonto.citas.controller;

import com.odonto.citas.model.Appointment;
import com.odonto.citas.service.AppointmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService service;

    public AppointmentController(AppointmentService service) {
        this.service = service;
    }

    @PostMapping
    public Appointment crear(@RequestBody Appointment cita) {
        return service.crear(cita);
    }

    @GetMapping
    public List<Appointment> listar() {
        return service.listar();
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        service.eliminar(id);
    }

    // 👇 NUEVO: Endpoint para modificar (CRUD: Update)
    @PutMapping("/{id}")
    public Appointment actualizar(@PathVariable String id, @RequestBody Appointment cita) {
        return service.actualizar(id, cita);
    }
}