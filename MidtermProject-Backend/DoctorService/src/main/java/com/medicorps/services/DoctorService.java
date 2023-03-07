package com.medicorps.services;

import java.util.List;

import com.medicorps.dto.AppointmentDto;
import com.medicorps.dto.PatientDto;
import com.medicorps.dto.PrescriptionDto;
import com.medicorps.dto.TestDto;

public interface DoctorService {

	List<PatientDto> viewPatientsOfDoc(int id);
	List<AppointmentDto> viewAllAppointments(int id);
	String sendForTest(TestDto testDto);
	List<TestDto> testResultOfPatient(int id);
	String setDiagnosis(int id , String diagnosis);
	PrescriptionDto addPrescription(int id , PrescriptionDto prescriptionDto);
	List<PrescriptionDto> viewPrescription(int id);
	String editPrescriptionById(PrescriptionDto prescriptionDto);
	String deletePrescriptionById(int id);
}
