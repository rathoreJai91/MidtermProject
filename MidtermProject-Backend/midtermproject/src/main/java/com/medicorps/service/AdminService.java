package com.medicorps.service;

import java.util.List;

import com.medicorps.dto.AdminDto;
import com.medicorps.dto.DepartmentDto;

public interface AdminService {

	//ADMIN
	AdminDto addAdmin(AdminDto adminDto);
	
	//DEPARTMENT
	DepartmentDto addDept(DepartmentDto departmentDto);
	DepartmentDto deleteDeptById(int id);
	List<DepartmentDto> viewAllDept();
	DepartmentDto viewDeptById(int id);
	DepartmentDto updateDepartmentById(int id, DepartmentDto departmentDto);
	
	

}
