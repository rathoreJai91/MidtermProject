package com.medicorps.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicorps.dto.PatientDto;
import com.medicorps.exception.IdNotFoundException;
import com.medicorps.model.Department;
import com.medicorps.model.Doctor;
import com.medicorps.model.Patient;
import com.medicorps.repository.DepartmentRepository;
import com.medicorps.repository.DoctorRepository;
import com.medicorps.repository.PatientRepository;
import com.medicorps.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	DepartmentRepository departmentRepo;
	@Autowired
	PatientRepository patientRepo;
	@Autowired
	DoctorRepository doctorRepo;
	
	private ModelMapper model = new ModelMapper();

	@Override
	public PatientDto add(PatientDto patientDto) {
		Patient patient = new ModelMapper().map(patientDto, Patient.class);
		patient.setStatus("Registered");
		return model.map(patientRepo.save(patient), PatientDto.class);
	}

	@Override
	public PatientDto viewById(int id) {
		return model.map(patientRepo.findById(id), PatientDto.class);
	}

	@Override
	public PatientDto deleteById(int id) {
		Patient patient = patientRepo.findById(id).orElseThrow(()->
								new IdNotFoundException("patient not found"));
		patientRepo.deleteById(id);
		PatientDto dto = model.map(patient,PatientDto.class);
		dto.setStatus("Deleted Successfully");
		return dto;
	}

	@Override
	public List<PatientDto> viewByDocId(int id) {
		Doctor doctor = doctorRepo.findById(id).orElseThrow(()->
						new IdNotFoundException("Doctor not found"));
		List<Patient> patients = doctor.getPatients();
		if(patients.isEmpty()) {
			throw new IdNotFoundException("No patients available");
		}
		List<PatientDto> patientDtos = new ArrayList<>();
		for(PatientDto patientDto : patientDtos) {
			patientDtos.add(model.map(patientDto, PatientDto.class));
		}
		return patientDtos;
	}

	@Override
	public List<PatientDto> viewByDeptId(int id) {
		Department department = departmentRepo.findById(id).orElseThrow(()->
						new IdNotFoundException("Department not found"));
		List<Patient> patients = department.getPatients();
		if(patients.isEmpty()) {
			throw new IdNotFoundException("No patients available");
		}
		List<PatientDto> patientDtos = new ArrayList<>();
		for(PatientDto patientDto : patientDtos) {
			patientDtos.add(model.map(patientDto, PatientDto.class));
		}
		return patientDtos;
	}

	@Override
	public PatientDto update(PatientDto patientDto) {
		Patient patient = patientRepo.findById(patientDto.getPatientId()).orElseThrow(()->
							new IdNotFoundException("patient not available"));
		patient = model.map(patientDto, Patient.class);
		return model.map(patientRepo.save(patient), PatientDto.class);
	}
	
	
	
	
}
