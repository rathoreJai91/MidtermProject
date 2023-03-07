package com.medicorps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicorps.model.Staff;

public interface StaffRepository extends JpaRepository<Staff,Integer>{
    
}
