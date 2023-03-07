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
import com.medicorps.dto.PatientDto;
import com.medicorps.dto.PrescriptionDto;
import com.medicorps.dto.TestDto;
import com.medicorps.services.DoctorService;

@RestController
@RequestMapping("/medicorps/doctor")
public class DoctorController {
	
	@Autowired
	DoctorService docService;
	
	@GetMapping("/{id}/patients")
	public ResponseEntity<List<PatientDto>> getPatients(@PathVariable int id) {
		return new ResponseEntity<>(docService.viewPatientsOfDoc(id), HttpStatus.OK);
	}
	
	@GetMapping("/{id}/appointments")
	public ResponseEntity<List<AppointmentDto>> getAppointmeents(@PathVariable int id) {
		return new ResponseEntity<>(docService.viewAllAppointments(id), HttpStatus.OK);
	}

	@PostMapping("/patient/sendfortest")
	public ResponseEntity<String> sendForTest(@RequestBody TestDto testDto) {
		return new ResponseEntity<>(docService.sendForTest(testDto), HttpStatus.OK);
	}
	
	@GetMapping("/patient/{id}/testResults")
	public ResponseEntity<List<TestDto>> testResults(@PathVariable int id) {
		return new ResponseEntity<>(docService.testResultOfPatient(id), HttpStatus.OK);
	}
	
	@PutMapping("/patient/{id}/diagnosis")
	public ResponseEntity<String> postDiagnosis(@PathVariable int id,@RequestBody String diagnosis) {
		return new ResponseEntity<>(docService.setDiagnosis(id,diagnosis), HttpStatus.OK);
	}

	@PostMapping("/{id}/patient/addprescription")
	public ResponseEntity<PrescriptionDto> givePrescription(@PathVariable int id ,@RequestBody PrescriptionDto prescriptionDto) {
		return new ResponseEntity<>(docService.addPrescription(id , prescriptionDto), HttpStatus.OK);
	}
	
	@GetMapping("/{id}/patient/viewprescription")
	public ResponseEntity<List<PrescriptionDto>> viewPrescription(@PathVariable int id) {
		return new ResponseEntity<>(docService.viewPrescription(id), HttpStatus.OK);
	}
	
	@PutMapping("/patient/updateprescription")
	public ResponseEntity<String> updatePrescription(@RequestBody PrescriptionDto prescriptionDto) {
		return new ResponseEntity<>(docService.editPrescriptionById(prescriptionDto), HttpStatus.OK);
	}
	
	@DeleteMapping("/patient/deleteprescription/{id}")
	public ResponseEntity<String> deletePrescription(@PathVariable int id) {
		return new ResponseEntity<>(docService.deletePrescriptionById(id), HttpStatus.OK);
	}
	
	
}
