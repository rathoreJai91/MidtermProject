package com.medicorps.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Test {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int testId;
	private String status;
	private LocalDateTime testDateTime;
	private LocalDateTime resultDateTime;
	private String result;
	
	@ManyToOne
	@JoinColumn(name = "testListId" , referencedColumnName = "testListId")
	private TestList testList;
	
	@ManyToOne
	@JoinColumn(name = "patientId" , referencedColumnName = "patientId")
	private Patient patient;

	public Test() {
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

	public TestList getTestList() {
		return testList;
	}

	public void setTestList(TestList testList) {
		this.testList = testList;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
}
