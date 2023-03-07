package com.medicorps.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicorps.dto.AppointmentDto;
import com.medicorps.exception.IdNotFoundException;
import com.medicorps.model.Appointment;
import com.medicorps.model.Doctor;
import com.medicorps.model.Patient;
import com.medicorps.repository.AppointmentRepository;
import com.medicorps.repository.DoctorRepository;
import com.medicorps.repository.PatientRepository;
import com.medicorps.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService{

	@Autowired
	DoctorRepository doctorRepo;
	@Autowired
	PatientRepository patientRepo;
	@Autowired
	AppointmentRepository appRepo;
	
	ModelMapper model = new ModelMapper();
	
	@Override
	public String setAppointment(AppointmentDto appointmentDto) {
		Doctor doc = doctorRepo.findById(appointmentDto.getDoctorId()).orElseThrow(()->
					new IdNotFoundException("not working bro"));
		Patient patient = patientRepo.findById(appointmentDto.getPatientId()).orElseThrow(()->
					new IdNotFoundException("not working bro"));
		Appointment app = model.map(appointmentDto, Appointment.class);
		app.setDoctor(doc);
		app.setPatient(patient);
		app.setDepartment(doc.getDepartment());
		patient.setStatus("Appointment Fixed");
		patient.setDoctor(doc);
		patient.setDepartment(doc.getDepartment());
		patientRepo.save(patient);
		appRepo.save(app);
		return "Appointment fixed";
	}

	@Override
	public List<AppointmentDto> viewPatientAppointments(int id) {
		List<Appointment> apps = appRepo.findAllByPatientPatientId(id).orElseThrow(()->
									new IdNotFoundException("not working bro"));
		if(apps.isEmpty()) {
			throw new IdNotFoundException("no appointments");
		}
		List<AppointmentDto> appDtos = new ArrayList<>();
		for(Appointment app : apps) {
			AppointmentDto dto = model.map(app, AppointmentDto.class);
			dto.setDeptId(app.getDepartment().getDeptId());
			dto.setDoctorId(app.getDoctor().getDocId());
			dto.setDoctorName(app.getDoctor().getDocName());
			dto.setPatientId(app.getPatient().getPatientId());
			dto.setPatientName(app.getPatient().getPatientName());
			dto.setProblem(app.getPatient().getProblem());
			appDtos.add(dto);
		}
		return appDtos;
	}

	@Override
	public List<AppointmentDto> viewDoctorAppointments(int id) {
		List<Appointment> apps = appRepo.findAllByDoctorDocId(id).orElseThrow(()->
								new IdNotFoundException("not working bro"));
		if(apps.isEmpty()) {
			throw new IdNotFoundException("No Appointments Available");
		}
		List<AppointmentDto> appsDto = new ArrayList<>();
 		for(Appointment app : apps) {
			AppointmentDto appDto = model.map(app , AppointmentDto.class);
			appDto.setDoctorId(app.getDoctor().getDocId());
			appDto.setDoctorName(app.getDoctor().getDocName());
			appDto.setPatientId(app.getPatient().getPatientId());
			appDto.setPatientName(app.getPatient().getPatientName());
			appDto.setProblem(app.getPatient().getProblem());
			appsDto.add(appDto);
		}
		return appsDto;
	}

	@Override
	public String deleteByAppId(int id) {
		appRepo.delete(appRepo.findById(id).orElseThrow(()->
		new IdNotFoundException("not working bro")));
		return "Appointment Deleted";
	}

	@Override
	public String updateAppointment(AppointmentDto appointmentDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
