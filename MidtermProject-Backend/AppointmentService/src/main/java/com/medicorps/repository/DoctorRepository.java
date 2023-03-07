package com.medicorps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicorps.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Integer>{
    
	//public List<Doctor> findAllByDeptId(int id);
}
