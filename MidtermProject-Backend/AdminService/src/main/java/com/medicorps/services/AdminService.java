package com.medicorps.services;

import java.util.List;

import com.medicorps.dto.AdminDto;
import com.medicorps.dto.DepartmentDto;
import com.medicorps.dto.DoctorDto;
import com.medicorps.dto.ReceptionistDto;
import com.medicorps.dto.StaffDto;
import com.medicorps.dto.TestListDto;

public interface AdminService {

	//ADMIN
	AdminDto addAdmin(AdminDto adminDto);
		
	//DEPARTMENT
	DepartmentDto addDept(DepartmentDto departmentDto);
	DepartmentDto deleteDeptById(int id);
	List<DepartmentDto> viewAllDept();
	DepartmentDto viewDeptById(int id);
	DepartmentDto updateDept(DepartmentDto departmentDto);
	
	//DOCTOR
	DoctorDto addDocByDeptId(int id, DoctorDto doctorDto);
	List<DoctorDto> viewAllDoctor();
	List<DoctorDto> viewDocByDeptId(int id);
	DoctorDto viewDocById(int id);
	DoctorDto updateDocById(DoctorDto doctorDto);
	DoctorDto deleteDocById(int id);
	
	//RECEPTIONIST
	ReceptionistDto addRecepByDeptId(int id, ReceptionistDto receptionistDto);
	List<ReceptionistDto> viewRecepAll();
	List<ReceptionistDto> viewRecepByDeptId(int id);
	ReceptionistDto viewRecepById(int id);
	ReceptionistDto updateRecepById(int id, ReceptionistDto receptionistDto);
	ReceptionistDto deleteRecepById(int id);
	
	//STAFF
	StaffDto addStaffByDeptId(int id , StaffDto staffDto);
	List<StaffDto> viewStaffAll();
	List<StaffDto> viewStaffByDeptId(int id);
	StaffDto viewStaffById(int id);
	StaffDto updateStaffById(int id,StaffDto staffDto);
	StaffDto deleteStaffById(int id);
	
	//LAB TEST
	TestListDto addTests(TestListDto testListDto);
	List<TestListDto> viewAllTests();
	TestListDto updateTest(int id ,TestListDto testListDto);
	TestListDto viewTestById(int id);
	TestListDto deleteTestById(int id);
	
	
	
}
