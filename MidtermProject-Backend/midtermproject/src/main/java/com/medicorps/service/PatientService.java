package com.medicorps.service;

import java.util.List;

import com.medicorps.dto.PatientDto;

public interface PatientService {

	PatientDto add(PatientDto patientDto);
	PatientDto viewById(int id);
	PatientDto deleteById(int id);
	List<PatientDto> viewByDocId(int id);
	List<PatientDto> viewByDeptId(int id);
	PatientDto update(PatientDto patientDto);
	
}
