package com.medicorps.dto;

import java.util.List;

public class ReportsDto {
	
	private int reportId;
	private int patientId;
	private String patientName;
	private String doctorName;
	private String diagnosis;
	private String prescription;
	
	private List<TestDto> testResults;
	
	public ReportsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getReportId() {
		return reportId;
	}
	public void setReportId(int reportId) {
		this.reportId = reportId;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getPrescription() {
		return prescription;
	}
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	public List<TestDto> getTestResults() {
		return testResults;
	}
	public void setTestResults(List<TestDto> testResults) {
		this.testResults = testResults;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	
	
}
