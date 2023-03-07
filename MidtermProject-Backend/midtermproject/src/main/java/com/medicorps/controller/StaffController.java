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

import com.medicorps.dto.StaffDto;
import com.medicorps.service.StaffService;

@RestController
@RequestMapping("/medicorps/staff")
public class StaffController {

	@Autowired
	StaffService staffService;
	
	@PostMapping("/addbydeptid/{id}")
	public ResponseEntity<StaffDto> addByDeptId(@PathVariable int id,@RequestBody StaffDto staffDto) {
		return new ResponseEntity<>( staffService.addByDeptId(id,staffDto), HttpStatus.OK);
	}
	
	@GetMapping("/viewall")
	public ResponseEntity<List<StaffDto>> viewAll() {
		return new ResponseEntity<>( staffService.viewAll(), HttpStatus.OK);
	}
	
	@GetMapping("/viewbydeptid/{id}")
	public ResponseEntity<List<StaffDto>> viewByDeptId(@PathVariable int id) {
		return new ResponseEntity<>( staffService.viewByDeptId(id), HttpStatus.OK);
	}
	
	@GetMapping("/viewbyid/{id}")
	public ResponseEntity<StaffDto> viewById(@PathVariable int id) {
		return new ResponseEntity<StaffDto>( staffService.viewById(id), HttpStatus.OK);
	}
	
	@PutMapping("/updatebyid/{id}")
	public ResponseEntity<StaffDto> updateById(@PathVariable int id , @RequestBody StaffDto staffDto) {
		return new ResponseEntity<StaffDto>( staffService.updateById(id, staffDto), HttpStatus.OK);
	}
	
	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<StaffDto> deleteById(@PathVariable int id) {
		return new ResponseEntity<StaffDto>( staffService.deleteById(id), HttpStatus.OK);
	}
}
