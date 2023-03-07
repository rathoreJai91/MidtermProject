package com.medicorps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicorps.model.Receptionist;

public interface ReceptionistRepository extends JpaRepository<Receptionist,Integer>{
 
	public List<Receptionist> findAllByDepartment(int id);
}
