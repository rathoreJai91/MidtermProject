package com.medicorps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicorps.model.Department;

public interface DepartmentRepository extends JpaRepository<Department,Integer>{
    
}
