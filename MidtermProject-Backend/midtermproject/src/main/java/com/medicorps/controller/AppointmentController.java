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
import com.medicorps.service.AppointmentService;

@RestController
@RequestMapping("medicorps/appointment")
public class AppointmentController {
	
	@Autowired
	AppointmentService appService;

	@PostMapping("/add")
	public ResponseEntity<AppointmentDto> book(@RequestBody AppointmentDto appointmentDto){
		return new ResponseEntity<>(appService.book(appointmentDto), HttpStatus.OK);
	}
	
	@DeleteMapping("/removebyid/{id}")
	public ResponseEntity<AppointmentDto> removeById(@PathVariable int id){
		return new ResponseEntity<>(appService.removeById(id), HttpStatus.OK);
	}
	
	@GetMapping("/viewby/deptid/{id}")
	public ResponseEntity<List<AppointmentDto>> viewByDeptId(@PathVariable int id) {
		return new ResponseEntity<>(appService.viewByDeptId(id), HttpStatus.OK);
	}
	
	@GetMapping("/viewby/docid/{id}")
	public ResponseEntity<List<AppointmentDto>> viewByDocId(@PathVariable int id) {
		return new ResponseEntity<>(appService.viewByDocId(id), HttpStatus.OK);
	}
	
	@GetMapping("/viewby/patientid/{id}")
	public ResponseEntity<List<AppointmentDto>> viewByPatientId(@PathVariable int id){
		return new ResponseEntity<>(appService.viewByPatentId(id), HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<AppointmentDto> update(@RequestBody AppointmentDto appointmentDto){
		return new ResponseEntity<>(appService.update(appointmentDto), HttpStatus.OK);
	}
	
	
}
