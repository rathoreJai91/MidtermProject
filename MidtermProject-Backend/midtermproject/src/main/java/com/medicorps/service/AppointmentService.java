package com.medicorps.service;

import java.util.List;

import com.medicorps.dto.AppointmentDto;

public interface AppointmentService {

	AppointmentDto book(AppointmentDto appointmentDto);
	AppointmentDto removeById(int id);
	List<AppointmentDto> viewByDeptId(int id);
	List<AppointmentDto> viewByDocId(int id);
	List<AppointmentDto> viewByPatentId(int id);
	AppointmentDto update(AppointmentDto appointmentDto);
	
}
