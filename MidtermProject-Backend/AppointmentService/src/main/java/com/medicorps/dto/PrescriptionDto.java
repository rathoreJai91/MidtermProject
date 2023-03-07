package com.medicorps.dto;

import java.time.LocalDate;

public class PrescriptionDto {
	
	private int presId;
	private int patientId;
	private String patientName;
	private String docName;
	private LocalDate dateofPrescription;
	private String medication;
	private String dosage;
	private String instructions;
	public PrescriptionDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPresId() {
		return presId;
	}
	public void setPresId(int presId) {
		this.presId = presId;
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
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public LocalDate getDateofPrescription() {
		return dateofPrescription;
	}
	public void setDateofPrescription(LocalDate dateofPrescription) {
		this.dateofPrescription = dateofPrescription;
	}
	public String getMedication() {
		return medication;
	}
	public void setMedication(String medication) {
		this.medication = medication;
	}
	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	
}
