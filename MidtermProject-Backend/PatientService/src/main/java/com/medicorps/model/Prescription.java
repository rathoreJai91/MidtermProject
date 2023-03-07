package com.medicorps.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Prescription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int presId;
	private LocalDate dateofPrescription;
	private String medication;
	private String dosage;
	private String instructions;
	
	@ManyToOne
	@JoinColumn(name = "patientId", referencedColumnName = "patientId")
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name = "docId" , referencedColumnName = "docId")
	private Doctor doctor;
	
	public Prescription() {
		super();
	}
	public int getPresId() {
		return presId;
	}
	public void setPresId(int presId) {
		this.presId = presId;
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
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	
}
