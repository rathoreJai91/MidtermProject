package com.medicorps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicorps.model.Admin;

public interface AdminRepository extends JpaRepository<Admin ,Integer>{
    
}
