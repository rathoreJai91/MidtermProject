package com.medicorps.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicorps.dto.AppointmentDto;
import com.medicorps.exception.IdNotFoundException;
import com.medicorps.model.Appointment;
import com.medicorps.model.Department;
import com.medicorps.model.Doctor;
import com.medicorps.model.Patient;
import com.medicorps.repository.AppointmentRepository;
import com.medicorps.repository.DepartmentRepository;
import com.medicorps.repository.DoctorRepository;
import com.medicorps.repository.PatientRepository;
import com.medicorps.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService{

	@Autowired
	DepartmentRepository departmentRepo;
	@Autowired
	PatientRepository patientRepo;
	@Autowired
	DoctorRepository doctorRepo;
	@Autowired
	AppointmentRepository appRepo;
	
	private ModelMapper model = new ModelMapper();
	
	@Override
	public AppointmentDto book(AppointmentDto appointmentDto) {
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
		AppointmentDto appDto = model.map(appRepo.save(app), AppointmentDto.class);
		appDto.setPatientId(patient.getPatientId());
		appDto.setPatientName(patient.getPatientName());
		appDto.setDoctorId(doc.getDocId());
		appDto.setDoctorName(doc.getDocName());
		appDto.setProblem(patient.getProblem());
		appDto.setDeptId(doc.getDepartment().getDeptId());
		return appDto;
	}

	@Override
	public AppointmentDto removeById(int id) {
		Appointment app = appRepo.findById(id).orElseThrow(()->
						new IdNotFoundException("not working bro"));
		appRepo.deleteById(id);
		return model.map(app, AppointmentDto.class);
	}

	@Override
	public List<AppointmentDto> viewByDeptId(int id) {
		Department department = departmentRepo.findById(id).orElseThrow(()->
								new IdNotFoundException("Wrong Department Id"));
		List<Appointment> apps = department.getAppointments();
		if(apps.isEmpty()) {
			throw new IdNotFoundException("No Appointments Available");
		}
		List<AppointmentDto> appsDto = new ArrayList<>();
 		for(Appointment app : apps) {
			AppointmentDto appDto = model.map(app , AppointmentDto.class);
			appDto.setDeptId(app.getDepartment().getDeptId());
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
	public List<AppointmentDto> viewByDocId(int id) {
//		Doctor doc = doctorRepo.findById(id).orElseThrow(()->
//						new IdNotFoundException("Wrong Doctor Id"));
		List<Appointment> apps = appRepo.findAllByDoctorDocId(id);
		if(apps.isEmpty()) {
			throw new IdNotFoundException("No Appointments Available");
		}
		List<AppointmentDto> appsDto = new ArrayList<>();
 		for(Appointment app : apps) {
			AppointmentDto appDto = model.map(app , AppointmentDto.class);
			appDto.setDeptId(app.getDepartment().getDeptId());
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
	public AppointmentDto update(AppointmentDto appDto) {
		Appointment app = appRepo.findById(appDto.getAppointmentId()).orElseThrow(()->
							new IdNotFoundException("appointment not found"));
		Doctor doc = doctorRepo.findById(appDto.getDoctorId()).orElseThrow(()->
							new IdNotFoundException("doctor not found"));
		app.setDoctor(doc);
		app.setDate(appDto.getDate());
		app.setTime(appDto.getTime());
		appDto = model.map( appRepo.save(app),AppointmentDto.class);
		appDto.setDoctorId(doc.getDocId());
		appDto.setDoctorName(doc.getDocName());
		return appDto;
	}

	@Override
	public List<AppointmentDto> viewByPatentId(int id) {
		List<Appointment> apps = patientRepo.findById(id).orElseThrow(()->
							new IdNotFoundException("not working bro")).getAppointment();
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

}
