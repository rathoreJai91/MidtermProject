package com.medicorps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicorps.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{
	
}
