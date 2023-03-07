package com.medicorps.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicorps.dto.PatientDto;
import com.medicorps.exception.IdNotFoundException;
import com.medicorps.model.Patient;
import com.medicorps.repository.PatientRepository;
import com.medicorps.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	PatientRepository patientRepo;
	
	ModelMapper model = new ModelMapper();
	
	@Override
	public PatientDto add(PatientDto patientDto) {
		Patient patient = new ModelMapper().map(patientDto, Patient.class);
		patient.setStatus("Registered");
		return model.map(patientRepo.save(patient), PatientDto.class);
	}

	@Override
	public String deleteById(int id) {
		patientRepo.deleteById(patientRepo.findById(id).orElseThrow(()->
		new IdNotFoundException("patient not found")).getPatientId());
		return "Deleted Successfully";
	}

	@Override
	public PatientDto update(PatientDto patientDto) {
		Patient patient = patientRepo.findById(patientDto.getPatientId()).orElseThrow(()->
						new IdNotFoundException("patient not available"));
		patient = model.map(patientDto, Patient.class);
		return model.map(patientRepo.save(patient), PatientDto.class);
	}

	@Override
	public PatientDto viewByPatientId(int id) {
		return model.map(patientRepo.findById(id).orElseThrow(()->
					new IdNotFoundException("name not available")), PatientDto.class);
	}

	@Override
	public List<PatientDto> viewByDeptId(int id) {
		List<Patient> patients = patientRepo.findAllByDepartmentDeptId(id).orElseThrow(()->
								new IdNotFoundException("Department not found"));
		if(patients.isEmpty()) {
			throw new IdNotFoundException("No patients available");
		}
		List<PatientDto> patientDtos = new ArrayList<>();
		for(PatientDto patientDto : patientDtos) {
			patientDtos.add(model.map(patientDto, PatientDto.class));
		}
		return patientDtos;
	}

}
