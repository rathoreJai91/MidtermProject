package com.medicorps.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicorps.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{

	Optional<List<Appointment>> findAllByDoctorDocId(int id);

	
}
