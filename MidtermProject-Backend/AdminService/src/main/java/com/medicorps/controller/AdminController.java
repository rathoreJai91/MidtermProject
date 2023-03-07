package com.medicorps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicorps.dto.AdminDto;
import com.medicorps.dto.DepartmentDto;
import com.medicorps.dto.DoctorDto;
import com.medicorps.dto.ReceptionistDto;
import com.medicorps.dto.StaffDto;
import com.medicorps.dto.TestListDto;
import com.medicorps.services.AdminService;

@RestController
@RequestMapping("/medicorps/admin")
@CrossOrigin("http://localhost:3000")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	//ADMIN
	@PostMapping("/add")
	public ResponseEntity<AdminDto> addAdmin(@RequestBody AdminDto adminDto) {
		return new ResponseEntity<AdminDto>(adminService.addAdmin(adminDto), HttpStatus.OK);
	}
	
	//DEPARTMENT
	
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
	
	@GetMapping("/department/update/{id}")
	public ResponseEntity<DepartmentDto> updateDept(@RequestBody DepartmentDto departmentDto) {
		return new ResponseEntity<DepartmentDto>(adminService.updateDept(departmentDto), HttpStatus.OK);
	}
	
	//DOCTOR
	
	@PostMapping("/doctor/add/{id}")
	public ResponseEntity<DoctorDto> addDocByDeptId(@PathVariable int id,@RequestBody DoctorDto doctorDto) {
		return new ResponseEntity<>(adminService.addDocByDeptId(id,doctorDto), HttpStatus.OK);
	}
	
	@GetMapping("/doctor/viewbydeptid/{id}")
	public ResponseEntity<List<DoctorDto>> viewDocByDeptId(@PathVariable int id) {
		return new ResponseEntity<>(adminService.viewDocByDeptId(id), HttpStatus.OK);
	}

	@GetMapping("/doctor/viewall")
	public ResponseEntity<List<DoctorDto>> viewAllDoc() {
		return new ResponseEntity<>(adminService.viewAllDoctor(), HttpStatus.OK);
	}

	@GetMapping("/doctor/viewbyid/{id}")
	public ResponseEntity<DoctorDto> viewDocById(@PathVariable int id) {
		return new ResponseEntity<DoctorDto>(adminService.viewDocById(id), HttpStatus.OK);
	}
	
	@PutMapping("/doctor/update/{id}")
	public ResponseEntity<DoctorDto> updateDocById(@PathVariable int id , @RequestBody DoctorDto doctorDto) {
		return new ResponseEntity<DoctorDto>(adminService.updateDocById(doctorDto), HttpStatus.OK);
	}
	
	@DeleteMapping("/doctor/delete/{id}")
	public ResponseEntity<DoctorDto> deleteDocById(@PathVariable int id) {
		return new ResponseEntity<DoctorDto>(adminService.deleteDocById(id), HttpStatus.OK);
	}

	//RECEPTIONIST
	
	@PostMapping("/receptionist/add/{id}")
	public ResponseEntity<ReceptionistDto> addRecepByDeptId(@PathVariable int id,@RequestBody ReceptionistDto ReceptionistDto) {
		return new ResponseEntity<>( adminService.addRecepByDeptId(id,ReceptionistDto), HttpStatus.OK);
	}
	
	@GetMapping("/receptionist/viewall")
	public ResponseEntity<List<ReceptionistDto>> viewRecepAll() {
		return new ResponseEntity<>( adminService.viewRecepAll(), HttpStatus.OK);
	}
	
	@GetMapping("/receptionist/viewbydeptid/{id}")
	public ResponseEntity<List<ReceptionistDto>> viewRecepByDeptId(@PathVariable int id) {
		return new ResponseEntity<>( adminService.viewRecepByDeptId(id), HttpStatus.OK);
	}
	
	@GetMapping("/receptionist/viewbyid/{id}")
	public ResponseEntity<ReceptionistDto> viewRecep(@PathVariable int id) {
		return new ResponseEntity<ReceptionistDto>( adminService.viewRecepById(id), HttpStatus.OK);
	}
	
	@PutMapping("/receptionist/update/{id}")
	public ResponseEntity<ReceptionistDto> updateRecep(@PathVariable int id , @RequestBody ReceptionistDto ReceptionistDto) {
		return new ResponseEntity<ReceptionistDto>( adminService.updateRecepById(id, ReceptionistDto), HttpStatus.OK);
	}
	
	@DeleteMapping("/receptionist/delete/{id}")
	public ResponseEntity<ReceptionistDto> deleteRecep(@PathVariable int id) {
		return new ResponseEntity<ReceptionistDto>( adminService.deleteRecepById(id), HttpStatus.OK);
	}

	//STAFF
	
	@PostMapping("/staff/add/{id}")
	public ResponseEntity<StaffDto> addStaffByDeptId(@PathVariable int id,@RequestBody StaffDto staffDto) {
		return new ResponseEntity<>( adminService.addStaffByDeptId(id,staffDto), HttpStatus.OK);
	}
	
	@GetMapping("/staff/viewall")
	public ResponseEntity<List<StaffDto>> viewAllSatff() {
		return new ResponseEntity<>( adminService.viewStaffAll(), HttpStatus.OK);
	}
	
	@GetMapping("/staff/viewbydeptid/{id}")
	public ResponseEntity<List<StaffDto>> viewStaffByDeptId(@PathVariable int id) {
		return new ResponseEntity<>( adminService.viewStaffByDeptId(id), HttpStatus.OK);
	}
	
	@GetMapping("/staff/viewbyid/{id}")
	public ResponseEntity<StaffDto> viewStaffById(@PathVariable int id) {
		return new ResponseEntity<StaffDto>( adminService.viewStaffById(id), HttpStatus.OK);
	}
	
	@PutMapping("/staff/updatebyid/{id}")
	public ResponseEntity<StaffDto> updateStaff(@PathVariable int id , @RequestBody StaffDto staffDto) {
		return new ResponseEntity<StaffDto>( adminService.updateStaffById(id, staffDto), HttpStatus.OK);
	}
	
	@DeleteMapping("/staff/deletebyid/{id}")
	public ResponseEntity<StaffDto> deleteStaffById(@PathVariable int id) {
		return new ResponseEntity<StaffDto>( adminService.deleteStaffById(id), HttpStatus.OK);
	}

	//LAB TEST LIST
	
	@PostMapping("/testlist/add")
	public ResponseEntity<TestListDto> addTest(@RequestBody TestListDto testDto) {
		return new ResponseEntity<>(adminService.addTests(testDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/testlist/view")
	public ResponseEntity<List<TestListDto>> viewTestList() {
		return new ResponseEntity<>(adminService.viewAllTests(), HttpStatus.OK);
	}
	
	@GetMapping("/testlist/viewbyid/{id}")
	public ResponseEntity<TestListDto> viewTestByName(@PathVariable int id) {
		return new ResponseEntity<>(adminService.viewTestById(id), HttpStatus.OK);
	}
	
	@PutMapping("/testlist/update/{id}")
	public ResponseEntity<TestListDto> updateTest(@PathVariable int id , @RequestBody TestListDto testDto) {
		return new ResponseEntity<>(adminService.updateTest(id,testDto), HttpStatus.OK);
	}
	
	@DeleteMapping("/testlist/delete/{id}")
	public ResponseEntity<TestListDto> deleteTest(@PathVariable int id) {
		return new ResponseEntity<>(adminService.deleteTestById(id), HttpStatus.OK);
	}
}
