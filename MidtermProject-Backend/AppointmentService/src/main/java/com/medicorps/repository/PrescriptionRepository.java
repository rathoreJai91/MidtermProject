package com.medicorps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicorps.model.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, Integer>{

	
	
}
