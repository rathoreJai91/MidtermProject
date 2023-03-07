package com.medicorps.service;

import java.util.List;

import com.medicorps.dto.AppointmentDto;

public interface AppointmentService {

	String setAppointment(AppointmentDto appointmentDto);
	List<AppointmentDto> viewPatientAppointments(int id);
	List<AppointmentDto> viewDoctorAppointments(int id);
	String deleteByAppId(int id);
	String updateAppointment(AppointmentDto appointmentDto);
}
