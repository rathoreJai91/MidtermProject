package com.medicorps.service;

import java.util.List;

import com.medicorps.dto.StaffDto;

public interface StaffService {
	
	StaffDto addByDeptId(int id , StaffDto staffDto);
	List<StaffDto> viewAll();
	List<StaffDto> viewByDeptId(int id);
	StaffDto viewById(int id);
	StaffDto updateById(int id,StaffDto staffDto);
	StaffDto deleteById(int id);
}
