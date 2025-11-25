package com.odonto.citas.repository;

import com.odonto.citas.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistRepository extends JpaRepository<Dentist, String> {
}