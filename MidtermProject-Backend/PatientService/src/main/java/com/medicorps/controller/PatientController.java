package com.medicorps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicorps.dto.PatientDto;
import com.medicorps.service.PatientService;

@RestController
@RequestMapping("medicorps/patient")
public class PatientController {

	@Autowired
	PatientService service;
	
	@PostMapping("/add")
	public ResponseEntity<PatientDto> add(@RequestBody PatientDto patientDto) {
		return new ResponseEntity<>(service.add(patientDto), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@PathVariable int id) {
		return new ResponseEntity<>(service.deleteById(id), HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<PatientDto> update(PatientDto patientDto) {
		return new ResponseEntity<>(service.update(patientDto), HttpStatus.OK);
	}
	
	@GetMapping("/viewBydeptid/{id}")
	public ResponseEntity<List<PatientDto>> viewByDeptId(@PathVariable int id) {
		return new ResponseEntity<>(service.viewByDeptId(id), HttpStatus.OK);
	}
	
	@GetMapping("/viewbyid/{id}")
	public ResponseEntity<PatientDto> viewById(int id) {
		return new ResponseEntity<>(service.viewByPatientId(id), HttpStatus.OK);
	}
}
