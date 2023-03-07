package com.medicorps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicorps.model.Test;

public interface TestRepository extends JpaRepository<Test, Integer>{
//	public List<Test> findAllByPatientId
}
