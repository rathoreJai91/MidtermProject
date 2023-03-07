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
@RequestMapping("/medicorps/Appointment")
public class AppointmentController {

	@Autowired
	AppointmentService service;
	
	@PostMapping("/add")
	public ResponseEntity<String> setAppointment(@RequestBody AppointmentDto dto){
		return new ResponseEntity<String>(service.setAppointment(dto), HttpStatus.OK);
	}
	
	@GetMapping("/patient/{id}/all")
	public ResponseEntity<List<AppointmentDto>> viewPatientAppointment(@PathVariable int id){
		return new ResponseEntity<>(service.viewPatientAppointments(id), HttpStatus.OK);
	}
	
	@GetMapping("/doctor/{id}/all")
	public ResponseEntity<List<AppointmentDto>> viewDoctorAppointment(@PathVariable int id){
		return new ResponseEntity<>(service.viewDoctorAppointments(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}/delete")
	public ResponseEntity<String> deleteAppointment(@PathVariable int id){
		return new ResponseEntity<>(service.deleteByAppId(id), HttpStatus.OK);
	}
	
	@PutMapping("/{id}/update")
	public ResponseEntity<String> updateAppointment(@PathVariable int id,@RequestBody AppointmentDto dto){
		return new ResponseEntity<>(service.updateAppointment(dto), HttpStatus.OK);
	}
}
