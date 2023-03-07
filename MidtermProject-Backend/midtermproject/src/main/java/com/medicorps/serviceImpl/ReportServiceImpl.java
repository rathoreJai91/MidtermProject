package com.medicorps.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.medicorps.dto.ReportsDto;
import com.medicorps.exception.IdNotFoundException;
import com.medicorps.model.Patient;
import com.medicorps.model.Reports;
import com.medicorps.repository.PatientRepository;
import com.medicorps.repository.ReportRepository;
import com.medicorps.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService{

	@Autowired
	ReportRepository reportRepo;
	@Autowired
	PatientRepository patientRepo;
	
	ModelMapper model = new ModelMapper();
	
	@Override
	public ReportsDto generateReport(ReportsDto reportDto) {
		Patient patient = patientRepo.findById(reportDto.getPatientId()).orElseThrow(()->
						new IdNotFoundException("Id not present"));
		Reports report = model.map(reportDto , Reports.class);
		report.setPatient(patient);
		reportDto = model.map(reportRepo.save(report), ReportsDto.class);
		reportDto.setPatientId(patient.getPatientId());
		reportDto.setPatientName(patient.getPatientName());
		reportDto.setDoctorName(patient.getDoctor().getDocName());
		return reportDto;
	}

	@Override
	public ReportsDto viewFullReportbyPatientId(int id) {
		
		return null;
	}

}
