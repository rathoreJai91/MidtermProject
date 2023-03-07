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

import com.medicorps.dto.TestDto;
import com.medicorps.dto.TestListDto;
import com.medicorps.service.TestService;

@RestController
@RequestMapping("/medicorps/test")
public class TestController {

	@Autowired
	TestService testService;
	
	@PostMapping("/add")
	public ResponseEntity<TestListDto> addTest(@RequestBody TestListDto testDto) {
		return new ResponseEntity<>(testService.add(testDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/viewtestlist")
	public ResponseEntity<List<TestListDto>> viewTestList() {
		return new ResponseEntity<>(testService.viewAll(), HttpStatus.OK);
	}
	
	@GetMapping("/viewbyname/{testName}")
	public ResponseEntity<TestListDto> viewByName(@PathVariable String testName) {
		return new ResponseEntity<>(testService.viewbyName(testName), HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<TestListDto> updateTest(@RequestBody TestListDto testDto) {
		return new ResponseEntity<>(testService.updateTest(testDto), HttpStatus.OK);
	}
	
	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<TestListDto> deleteById(@PathVariable int id) {
		return new ResponseEntity<>(testService.deleteById(id), HttpStatus.OK);
	}
	
	@PostMapping("/sendfortest")
	public ResponseEntity<TestDto> sendForTest(@RequestBody TestDto testDto) {
		return new ResponseEntity<>(testService.sendForTest(testDto),HttpStatus.OK);
	}
	
	@GetMapping("/viewalltest")
	public ResponseEntity<List<TestDto>> viewAllTest() {
		return new ResponseEntity<>(testService.viewAllTest(),HttpStatus.OK);
	}
	
	@PutMapping("/taketest/{id}")
	public ResponseEntity<TestDto> TakeTest(@PathVariable int id) {
		return new ResponseEntity<>(testService.takeTest(id),HttpStatus.OK);
	}
	
	@PutMapping("/submitresult/{id}")
	public ResponseEntity<TestDto> submitResultById(@PathVariable int id , @RequestBody String result) {
		return new ResponseEntity<>(testService.submitResultsById(id,result),HttpStatus.OK);
	}
	
	@GetMapping("viewbypatientid/{id}")
	public ResponseEntity<List<TestDto>> getTestByPatientId(@PathVariable int id) {
		return new ResponseEntity<>(testService.getTestByPatientId(id),HttpStatus.OK);
	}
	
	
}
