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

import com.medicorps.dto.ReceptionistDto;
import com.medicorps.service.ReceptionistService;

@RestController
@RequestMapping("/medicorps/receptionist")
public class ReceptionistController {

	@Autowired
	ReceptionistService receptionistService;
	
	@PostMapping("/addbydeptid/{id}")
	public ResponseEntity<ReceptionistDto> addByDeptId(@PathVariable int id,@RequestBody ReceptionistDto ReceptionistDto) {
		return new ResponseEntity<>( receptionistService.addByDeptId(id,ReceptionistDto), HttpStatus.OK);
	}
	
	@GetMapping("/viewall")
	public ResponseEntity<List<ReceptionistDto>> viewAll() {
		return new ResponseEntity<>( receptionistService.viewAll(), HttpStatus.OK);
	}
	
	@GetMapping("/viewbydeptid/{id}")
	public ResponseEntity<List<ReceptionistDto>> viewByDeptId(@PathVariable int id) {
		return new ResponseEntity<>( receptionistService.viewByDeptId(id), HttpStatus.OK);
	}
	
	@GetMapping("/viewbyid/{id}")
	public ResponseEntity<ReceptionistDto> viewById(@PathVariable int id) {
		return new ResponseEntity<ReceptionistDto>( receptionistService.viewbyId(id), HttpStatus.OK);
	}
	
	@PutMapping("/updatebyid/{id}")
	public ResponseEntity<ReceptionistDto> updateById(@PathVariable int id , @RequestBody ReceptionistDto ReceptionistDto) {
		return new ResponseEntity<ReceptionistDto>( receptionistService.updateById(id, ReceptionistDto), HttpStatus.OK);
	}
	
	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<ReceptionistDto> deleteById(@PathVariable int id) {
		return new ResponseEntity<ReceptionistDto>( receptionistService.deleteById(id), HttpStatus.OK);
	}
}
