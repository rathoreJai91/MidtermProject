package com.medicorps.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicorps.dto.AdminDto;
import com.medicorps.dto.DepartmentDto;
import com.medicorps.exception.IdNotFoundException;
import com.medicorps.model.Admin;
import com.medicorps.model.Department;
import com.medicorps.repository.AdminRepository;
import com.medicorps.repository.DepartmentRepository;
import com.medicorps.service.AdminService;
import com.medicorps.utility.AppConstant;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminRepository adminRepository;
	@Autowired
	DepartmentRepository departmentRepository;
	
	ModelMapper model = new ModelMapper();

	@Override
	public AdminDto addAdmin(AdminDto adminDto) {
		Admin admin = model.map(adminDto,Admin.class);
		return model.map(adminRepository.save(admin), AdminDto.class);
	}
	
	@Override
	public DepartmentDto addDept(DepartmentDto departmentDto) {
		Department department = model.map(departmentDto,Department.class);
		return model.map(departmentRepository.save(department), DepartmentDto.class);
	}
	
	@Override
	public DepartmentDto deleteDeptById(int id) {
		Department dept = departmentRepository.findById(id).orElseThrow(()->
							new IdNotFoundException(AppConstant.ID_NOT_MESSAGE));
		departmentRepository.deleteById(id);
		return model.map(dept, DepartmentDto.class);
	}
	
	@Override
	public List<DepartmentDto> viewAllDept() {
		List<Department> departments = departmentRepository.findAll();
		if(departments.isEmpty()) {
			throw new IdNotFoundException("No departments available"); /// change this exception
		}
		List<DepartmentDto> departmentDtos = new ArrayList<>();
		for(Department department : departments) {
			departmentDtos.add(model.map(department, DepartmentDto.class));
		}
		return departmentDtos;
	}

	@Override
	public DepartmentDto viewDeptById(int id) {
		Department department = departmentRepository.findById(id).orElseThrow(()->
								new IdNotFoundException(AppConstant.ID_NOT_MESSAGE));
		DepartmentDto departmentDto = model.map(department, DepartmentDto.class);
		return departmentDto;
	}

	@Override
	public DepartmentDto updateDepartmentById(int id, DepartmentDto departmentDto) {
		
		
		Department department = departmentRepository.findById(id).orElseThrow(()->
								new IdNotFoundException(AppConstant.ID_NOT_MESSAGE));
		department.setDeptName(departmentDto.getDeptName());
		department.setNoOfEmps(departmentDto.getNoOfEmps());
		return model.map(departmentRepository.save(department), DepartmentDto.class);
	}
	
	

}
