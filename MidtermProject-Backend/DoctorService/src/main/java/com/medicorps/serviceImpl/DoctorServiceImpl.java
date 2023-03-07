package com.medicorps.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicorps.dto.AppointmentDto;
import com.medicorps.dto.PatientDto;
import com.medicorps.dto.PrescriptionDto;
import com.medicorps.dto.TestDto;
import com.medicorps.model.Patient;
import com.medicorps.model.Prescription;
import com.medicorps.model.Test;
import com.medicorps.model.TestList;
import com.medicorps.exception.IdNotFoundException;
import com.medicorps.model.Appointment;
import com.medicorps.model.Doctor;
import com.medicorps.repository.AppointmentRepository;
import com.medicorps.repository.DoctorRepository;
import com.medicorps.repository.PatientRepository;
import com.medicorps.repository.PrescriptionRepository;
import com.medicorps.repository.TestListRepository;
import com.medicorps.repository.TestRepository;
import com.medicorps.services.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{

	@Autowired
	DoctorRepository docRepo;
	@Autowired
	PatientRepository patientRepo;
	@Autowired
	TestListRepository testListRepo;
	@Autowired
	TestRepository testRepo;
	@Autowired
	PrescriptionRepository presRepo;
	@Autowired
	AppointmentRepository appRepo;
	
	ModelMapper model = new ModelMapper();
	
	@Override
	public List<PatientDto> viewPatientsOfDoc(int id) {
		List<Patient> patients = patientRepo.findAllByDoctorDocId(id).orElseThrow(()->
								new IdNotFoundException("Doctor not found"));
		if(patients.isEmpty()) {
			throw new IdNotFoundException("No patients available");
		}
		List<PatientDto> patientDtos = new ArrayList<>();
		for(PatientDto patientDto : patientDtos) {
			patientDtos.add(model.map(patientDto, PatientDto.class));
		}
		return patientDtos;
	}

	@Override
	public List<AppointmentDto> viewAllAppointments(int id) {
		List<Appointment> apps = appRepo.findAllByDoctorDocId(id).orElseThrow(()->
								new IdNotFoundException("Doctor not found"));
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
	public String sendForTest(TestDto testDto) {
		Test test = new Test();
		TestList testList = testListRepo.findByTestName(testDto.getTestName()).orElseThrow(()->
								new IdNotFoundException("Invalid test Name"));
		Patient patient = patientRepo.findById(testDto.getPatientId()).orElseThrow(()->
								new IdNotFoundException("Invalid Patient id"));
		test.setTestList(testList);
		patient.setStatus("Waiting for test results");
		patientRepo.save(patient);
		test.setPatient(patient);
		test.setStatus("Diagnosis Under Process");
		testRepo.save(test);
		return "Sent for a "+testList.getTestName();
	}

	@Override
	public List<TestDto> testResultOfPatient(int id) {
		List<Test> tests = patientRepo.findById(id).orElseThrow(()->
							new IdNotFoundException("Invalid Id")).getTests();
		if(tests.isEmpty()) {
			throw new IdNotFoundException("no tests taken");
		}
		List<TestDto> testDtos = new ArrayList<>();
		for(Test test : tests) {
			TestDto dto = model.map(test, TestDto.class);
			dto.setTestName(test.getTestList().getTestName());;
			dto.setPatientId(test.getPatient().getPatientId());
			dto.setPatientName(test.getPatient().getPatientName());;
			testDtos.add(dto);
		}
		return testDtos;
	}

	@Override
	public String setDiagnosis(int id, String diagnosis) {
		Patient patient = patientRepo.findById(id).orElseThrow(()->
							new IdNotFoundException("Invalid Patient id"));
		patient.setDiagnosis(diagnosis);
		patient.setStatus("Diagnosed");
		patientRepo.save(patient);
		return "Diagnosis Updated";
	}

	@Override
	public PrescriptionDto addPrescription(int id , PrescriptionDto prescriptionDto) {
		Patient patient = patientRepo.findById(prescriptionDto.getPatientId()).orElseThrow(()->
							new IdNotFoundException("Invalid Patient id"));
		Doctor doc = docRepo.findByDocName(prescriptionDto.getDocName()).orElseThrow(()->
					new IdNotFoundException("Invalid Patient id"));
		Prescription prescription = model.map(prescriptionDto, Prescription.class);
		prescription.setPatient(patient);
		prescription.setDoctor(doc);
		prescription.setDateofPrescription(LocalDate.now());
		prescriptionDto =  model.map(presRepo.save(prescription),PrescriptionDto.class);
		prescriptionDto.setPatientId(patient.getPatientId());
		prescriptionDto.setPatientName(patient.getPatientName());
		prescriptionDto.setDocName(doc.getDocName());
		return prescriptionDto;
	}

	
	@Override
	public List<PrescriptionDto> viewPrescription(int id) {
		List<Prescription> prescriptions = patientRepo.findById(id).orElseThrow(()->
									new IdNotFoundException("Invalid Patient id")).getPrescriptions();
		if(prescriptions.isEmpty()) {
			throw new IdNotFoundException("No prescription available");
		}
		List<PrescriptionDto> prescriptionDtos = new ArrayList<>();
		for(Prescription pres : prescriptions) {
			PrescriptionDto dto = model.map(pres, PrescriptionDto.class);
			dto.setPatientId(pres.getPatient().getPatientId());
			dto.setPatientName(pres.getPatient().getPatientName());
			dto.setDocName(pres.getDoctor().getDocName());
			prescriptionDtos.add(dto);
		}
		return prescriptionDtos;
	}

	@Override
	public String editPrescriptionById(PrescriptionDto prescriptionDto) {
		Prescription pres = presRepo.findById(prescriptionDto.getPresId()).orElseThrow(()->
							new IdNotFoundException(null));
		pres = model.map(prescriptionDto,Prescription.class);
		presRepo.save(pres);
		return "Prescription Updated";
	}

	@Override
	public String deletePrescriptionById(int id) {
		presRepo.deleteById(id);
		return "Deleted Successfully";
	}
	
	



}
