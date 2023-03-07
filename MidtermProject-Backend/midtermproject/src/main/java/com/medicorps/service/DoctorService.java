package com.medicorps.service;

import java.util.List;

import com.medicorps.dto.DoctorDto;

public interface DoctorService {

	//CRUD on doctor only accessed by admin
	DoctorDto addByDeptId(int id, DoctorDto doctorDto);
	List<DoctorDto> viewAll();
	List<DoctorDto> viewByDeptId(int id);
	DoctorDto viewById(int id);
	DoctorDto updateById(int id, DoctorDto doctorDto);
	DoctorDto deleteById(int id);
	
}
