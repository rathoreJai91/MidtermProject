package com.medicorps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicorps.dto.TestDto;
import com.medicorps.service.TestingService;

@RestController
@RequestMapping("/medicorps/lab")
public class TestingController {
	
	@Autowired
	TestingService service;
	
	@GetMapping("/viewAllTest")
	public ResponseEntity<List<TestDto>> viewAllTest() {
		return new ResponseEntity<>(service.viewAllTest(),HttpStatus.OK);
	}
	
	@PutMapping("/{id}/taketest")
	public ResponseEntity<String> takeTest(@PathVariable int id) {
		return new ResponseEntity<>(service.takeTest(id),HttpStatus.OK);
	}
	
	@PutMapping("/uploadResult/{id}")
	public ResponseEntity<TestDto> submitResult(@PathVariable int id , String result) {
		return new ResponseEntity<>(service.submitTestResult(id,result),HttpStatus.OK);
	}
	
	@GetMapping("/view/{id}")
	public ResponseEntity<TestDto> viewbyid(@PathVariable int id) {
		return new ResponseEntity<>(service.findByTestId(id),HttpStatus.OK);
	}
}
