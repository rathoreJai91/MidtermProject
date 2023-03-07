package com.medicorps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicorps.model.Reports;

public interface ReportRepository extends JpaRepository<Reports, Integer>{
	
}
