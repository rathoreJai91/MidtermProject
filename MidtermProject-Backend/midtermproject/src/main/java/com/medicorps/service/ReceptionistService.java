package com.medicorps.service;

import java.util.List;

import com.medicorps.dto.ReceptionistDto;

public interface ReceptionistService {

	ReceptionistDto addByDeptId(int id, ReceptionistDto receptionistDto);
	List<ReceptionistDto> viewAll();
	List<ReceptionistDto> viewByDeptId(int id);
	ReceptionistDto viewbyId(int id);
	ReceptionistDto updateById(int id, ReceptionistDto receptionistDto);
	ReceptionistDto deleteById(int id);
	
}
