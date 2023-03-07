package com.medicorps.dto;

import java.time.LocalDateTime;

public class TestDto {
	
	private int testId;
	private String status;
	private LocalDateTime testDateTime;
	private LocalDateTime resultDateTime;
	private String result;
	
	private String testName;
	private int patientId;
	private String patientName;
	
	public TestDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getTestDateTime() {
		return testDateTime;
	}
	public void setTestDateTime(LocalDateTime testDateTime) {
		this.testDateTime = testDateTime;
	}
	public LocalDateTime getResultDateTime() {
		return resultDateTime;
	}
	public void setResultDateTime(LocalDateTime resultDateTime) {
		this.resultDateTime = resultDateTime;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
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
	
	
}
