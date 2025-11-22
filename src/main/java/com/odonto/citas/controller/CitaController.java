package com.odonto.citas.controller;

import com.odonto.citas.model.Cita;
import com.odonto.citas.service.CitaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin // permite que tu app Android consuma desde otro origen
@RestController
@RequestMapping("/citas")
public class CitaController {

    private final CitaService service;

    public CitaController(CitaService service) {
        this.service = service;
    }

    // Crear cita (POST /citas)
    @PostMapping
    public Cita crear(@RequestBody Cita cita) {
        return service.crear(cita);
    }

    // Listar todas las citas (GET /citas)
    @GetMapping
    public List<Cita> listar() {
        return service.listar();
    }

    // Obtener una cita por id (GET /citas/{id})
    @GetMapping("/{id}")
    public Cita obtener(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // Eliminar una cita (DELETE /citas/{id})
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
