package com.odonto.citas.controller;

import com.odonto.citas.model.Dentist;
import com.odonto.citas.model.Patient;
import com.odonto.citas.repository.DentistRepository;
import com.odonto.citas.repository.PatientRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class DataController {

    private final DentistRepository dentistRepo;
    private final PatientRepository patientRepo;

    public DataController(DentistRepository dentistRepo, PatientRepository patientRepo) {
        this.dentistRepo = dentistRepo;
        this.patientRepo = patientRepo;
    }

    // --- Endpoints para Dentistas ---

    @GetMapping("/dentists")
    public List<Dentist> getDentists() {
        return dentistRepo.findAll();
    }

    // --- Endpoints para Pacientes ---

    @GetMapping("/patients/me")
    public Patient getMe() {
        // Retorna el paciente con ID "me", o crea uno vacío si no existe
        return patientRepo.findById("me").orElse(new Patient());
    }

    @PostMapping("/patients")
    public Patient updatePatient(@RequestBody Patient patient) {
        // Fuerza el ID a "me" para asegurar que siempre actualizamos el mismo perfil en esta demo
        patient.setId("me");
        return patientRepo.save(patient);
    }

    // --- "Seed" de datos iniciales (Opcional) ---
    // Esto pre-cargará algunos dentistas en la base de datos al arrancar si está vacía.
    @PostConstruct
    public void initData() {
        if (dentistRepo.count() == 0) {
            dentistRepo.save(new Dentist("Dra. Pérez", "Ortodoncia"));
            dentistRepo.save(new Dentist("Dr. Soto", "Endodoncia"));
            dentistRepo.save(new Dentist("Dra. Muñoz", "Implantología"));
            System.out.println(">>> Dentistas iniciales cargados.");
        }
    }
}