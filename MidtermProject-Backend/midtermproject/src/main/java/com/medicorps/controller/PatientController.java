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
@RequestMapping("/medicorps/patient")
public class PatientController {
	
	@Autowired
	PatientService patientService;
	
	@PostMapping("/add")
	public ResponseEntity<PatientDto> add(@RequestBody PatientDto patientDto) {
		return new ResponseEntity<>(patientService.add(patientDto), HttpStatus.OK);
	}
	
	@GetMapping("/viewbyid/{id}")
	public ResponseEntity<PatientDto> viewById(@PathVariable int id) {
		return new ResponseEntity<>(patientService.viewById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<PatientDto> deleteById(@PathVariable int id) {
		return new ResponseEntity<>(patientService.deleteById(id), HttpStatus.OK);
	}
	
	@GetMapping("/viewbydocid/{id}")
	public ResponseEntity<List<PatientDto>> viewByDocId(@PathVariable int id) {
		return new ResponseEntity<>(patientService.viewByDocId(id), HttpStatus.OK);
	}
	
	@GetMapping("/viewbydeptid/{id}")
	public ResponseEntity<List<PatientDto>> viewByDeptId(@PathVariable int id) {
		return new ResponseEntity<>(patientService.viewByDeptId(id), HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<PatientDto> updatePatient(@RequestBody PatientDto patientDto) {
		return new ResponseEntity<>(patientService.update(patientDto), HttpStatus.OK);
	}
}
