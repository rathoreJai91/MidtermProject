package com.medicorps.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicorps.model.Patient;

public interface PatientRepository extends JpaRepository<Patient,Integer>{

	Optional<Patient> findByPatientName(String name);

	Optional<List<Patient>> findAllByDepartmentDeptId(int id);
    
}
