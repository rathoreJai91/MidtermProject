package com.medicorps.dto;

import java.time.LocalDate;

public class DoctorDto {
    
	private int docId;
    private String docName;
    private String docEmail;
    private String speciality;
    private int experience;
    private String designation;
    private int fees;
    private String timings;
    private int docSalary;
    private LocalDate dateOfJoining;

    private int deptId;

	public DoctorDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDocEmail() {
		return docEmail;
	}

	public void setDocEmail(String docEmail) {
		this.docEmail = docEmail;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	public String getTimings() {
		return timings;
	}

	public void setTimings(String timings) {
		this.timings = timings;
	}

	public int getDocSalary() {
		return docSalary;
	}

	public void setDocSalary(int docSalary) {
		this.docSalary = docSalary;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	
	
    
    
}
