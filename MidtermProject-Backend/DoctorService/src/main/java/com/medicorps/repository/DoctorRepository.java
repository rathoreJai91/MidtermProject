package com.medicorps.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicorps.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Integer>{

	Optional<Doctor> findByDocName(String docName);
}
