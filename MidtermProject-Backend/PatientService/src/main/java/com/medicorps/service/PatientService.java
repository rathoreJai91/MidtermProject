package com.medicorps.service;

import java.util.List;

import com.medicorps.dto.PatientDto;

public interface PatientService {

	PatientDto add(PatientDto patientDto);
	String deleteById(int id);
	PatientDto update(PatientDto patientDto);
	List<PatientDto> viewByDeptId(int id);
	PatientDto viewByPatientId(int id);
}
