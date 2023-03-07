package com.medicorps.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicorps.dto.StaffDto;
import com.medicorps.exception.IdNotFoundException;
import com.medicorps.model.Department;
import com.medicorps.model.Staff;
import com.medicorps.repository.DepartmentRepository;
import com.medicorps.repository.StaffRepository;
import com.medicorps.service.StaffService;
import com.medicorps.utility.AppConstant;

@Service
public class StaffServiceImpl implements StaffService{

	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	StaffRepository staffRepository;
	
	@Override
	public StaffDto addByDeptId(int id , StaffDto staffDto) {
		Department department = departmentRepository.findById(id).orElseThrow(()->
								new IdNotFoundException(AppConstant.ID_NOT_MESSAGE));
		Staff staff = new ModelMapper().map(staffDto,Staff.class);
		staff.setDateOfJoining(LocalDate.now());
		staff.setDepartment(department);
		department.setNoOfEmps(department.getNoOfEmps()+1);
		departmentRepository.save(department);
		StaffDto staffD = new ModelMapper().map(staffRepository.save(staff), StaffDto.class);
		staffD.setDeptId(id);
		return staffD;
	}

	@Override
	public List<StaffDto> viewAll() {
		List<Staff> staffs = staffRepository.findAll();
		if(staffs.isEmpty()) {
			throw new IdNotFoundException(null);
		}
		List<StaffDto> staffDtos = new ArrayList<>();
		for(Staff staff : staffs) {
			StaffDto staffD = new ModelMapper().map(staff, StaffDto.class);
			staffD.setDeptId(staff.getDepartment().getDeptId());
			staffDtos.add(staffD);
		}
		return staffDtos;
	}

	@Override
	public List<StaffDto> viewByDeptId(int id) {
		Department department = departmentRepository.findById(id).orElseThrow(()->
								new IdNotFoundException(AppConstant.ID_NOT_MESSAGE));
		List<Staff> staffs = department.getStaff();
		if(staffs.isEmpty()) {
			throw new IdNotFoundException("No staff available");
		}
		List<StaffDto> staffDtos = new ArrayList<>();
		for(Staff staff : staffs) {
			StaffDto staffD = new ModelMapper().map(staff, StaffDto.class);
			staffD.setDeptId(staff.getDepartment().getDeptId());
			staffDtos.add(staffD);
		}
		return staffDtos;
	}

	@Override
	public StaffDto viewById(int id) {
		Staff staff = staffRepository.findById(id).orElseThrow(()->
					new IdNotFoundException(AppConstant.ID_NOT_MESSAGE));
		StaffDto staffDto = new ModelMapper().map(staff, StaffDto.class);
		staffDto.setDeptId(staff.getDepartment().getDeptId());
		return staffDto;
	}

	@Override
	public StaffDto updateById(int id, StaffDto staffDto) {
		Staff staff = staffRepository.findById(id).orElseThrow(()->
					new IdNotFoundException(AppConstant.ID_NOT_MESSAGE));
		staff.setStaffName(staffDto.getStaffName());
		staff.setStaffEmail(staffDto.getStaffEmail());
		staff.setStaffSalary(staffDto.getStaffSalary());
		staff.setStaffTiming(staffDto.getStaffTiming());
		StaffDto staffD = new ModelMapper().map(staff, StaffDto.class);
		staffD.setDeptId(staff.getDepartment().getDeptId());
		return staffD;
	}

	@Override
	public StaffDto deleteById(int id) {
		Staff staff = staffRepository.findById(id).orElseThrow(()->
					new IdNotFoundException(AppConstant.ID_NOT_MESSAGE));
		Department department = staff.getDepartment();
		department.setNoOfEmps(department.getNoOfEmps()-1);
		departmentRepository.save(department);
		staffRepository.deleteById(id);
		StaffDto staffDto = new ModelMapper().map(staff, StaffDto.class);
		staffDto.setDeptId(department.getDeptId());
		return staffDto;
	}

}
