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

import com.medicorps.dto.AppointmentDto;
import com.medicorps.dto.DoctorDto;
import com.medicorps.dto.PatientDto;
import com.medicorps.service.AppointmentService;
import com.medicorps.service.DoctorService;
import com.medicorps.service.PatientService;

@RestController
@RequestMapping("/medicorps/doctor")
public class DoctorController {
	
	@Autowired
	DoctorService doctorService;
	@Autowired
	AppointmentService appointmentService;
	@Autowired
	PatientService patientService;
	
	@PostMapping("/add/{id}")
	public ResponseEntity<DoctorDto> addByDeptId(@PathVariable int id,@RequestBody DoctorDto doctorDto) {
		return new ResponseEntity<>(doctorService.addByDeptId(id,doctorDto), HttpStatus.OK);
	}
	
	@GetMapping("/viewbydeptid/{id}")
	public ResponseEntity<List<DoctorDto>> viewByDeptId(@PathVariable int id) {
		return new ResponseEntity<>(doctorService.viewByDeptId(id), HttpStatus.OK);
	}

	@GetMapping("/viewall")
	public ResponseEntity<List<DoctorDto>> viewAll() {
		return new ResponseEntity<>(doctorService.viewAll(), HttpStatus.OK);
	}

	@GetMapping("/viewbydocid/{id}")
	public ResponseEntity<DoctorDto> viewById(@PathVariable int id) {
		return new ResponseEntity<DoctorDto>(doctorService.viewById(id), HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<DoctorDto> updateById(@PathVariable int id , @RequestBody DoctorDto doctorDto) {
		return new ResponseEntity<DoctorDto>(doctorService.updateById(id, doctorDto), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<DoctorDto> deleteById(@PathVariable int id) {
		return new ResponseEntity<DoctorDto>(doctorService.deleteById(id), HttpStatus.OK);
	}
	
	@GetMapping("/appointments/{id}")
	public ResponseEntity<List<AppointmentDto>> viewAppointmentsByDocId(@PathVariable int id){
		return new ResponseEntity<>(appointmentService.viewByDocId(id),HttpStatus.OK);
	}
	
//	@GetMapping("/patients/{id}")
//	public ResponseEntity<List<PatientDto>> viewByDocId(@PathVariable int id){
//		return new ResponseEntity<>(doctorService.,HttpStatus.OK);
//	}
	
}
