package com.odonto.citas.repository;

import com.odonto.citas.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
    // No hace falta escribir nada, JpaRepository ya trae CRUD básico.
}
