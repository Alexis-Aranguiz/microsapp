package com.odonto.citas.repository;

import com.odonto.citas.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// Cambiamos Cita por Appointment, y Long por String (el tipo del ID)
public interface AppointmentRepository extends JpaRepository<Appointment, String> {
}