package com.medicorps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicorps.model.Patient;

public interface PatientRepository extends JpaRepository<Patient,Integer>{
    
}
