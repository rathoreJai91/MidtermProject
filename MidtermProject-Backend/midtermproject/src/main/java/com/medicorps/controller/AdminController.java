package com.medicorps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicorps.dto.AdminDto;
import com.medicorps.dto.DepartmentDto;
import com.medicorps.dto.DoctorDto;
import com.medicorps.service.AdminService;
import com.medicorps.service.DoctorService;

@RestController
@RequestMapping("/medicorps")
public class AdminController {

	@Autowired
	AdminService adminService;
	@Autowired
	DoctorService doctorService;
	
	
	@PostMapping("/admin/add")
	public ResponseEntity<AdminDto> addAdmin(@RequestBody AdminDto adminDto) {
		return new ResponseEntity<AdminDto>(adminService.addAdmin(adminDto), HttpStatus.OK);
	}
	
	@PostMapping("/department/add")
	public ResponseEntity<DepartmentDto> addDepartment(@RequestBody DepartmentDto departmentDto) {
		return new ResponseEntity<DepartmentDto>(adminService.addDept(departmentDto), HttpStatus.OK);
	}

	@DeleteMapping("/department/delete/{id}")
	public ResponseEntity<DepartmentDto> deleteDeptById(@PathVariable int id) {
		return new ResponseEntity<DepartmentDto>(adminService.deleteDeptById(id),HttpStatus.OK);
	}
	
	@GetMapping("/department/viewall")
	public ResponseEntity<List<DepartmentDto>> viewAllDept() {
		return new ResponseEntity<List<DepartmentDto>>(adminService.viewAllDept(),HttpStatus.OK);
	}
	
	@GetMapping("/department/viewbyid/{id}")
	public ResponseEntity<DepartmentDto> viewDeptById(@PathVariable int id) {
		return new ResponseEntity<DepartmentDto>(adminService.viewDeptById(id), HttpStatus.OK);
	}
	
	
	
}
