package com.odonto.citas.service;

import com.odonto.citas.model.Cita;
import com.odonto.citas.repository.CitaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaService {

    private final CitaRepository repo;

    public CitaService(CitaRepository repo) {
        this.repo = repo;
    }

    public Cita crear(Cita cita) {
        return repo.save(cita);
    }

    public List<Cita> listar() {
        return repo.findAll();
    }

    public Cita buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
