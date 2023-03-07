package com.medicorps.dto;

import java.time.LocalDate;

public class ReceptionistDto {
    
	private int receptionistId;
    private String receptionistName;
    private String receptionistEmail;
    private int receptionistSalary;
    private LocalDate dateOfJoining;
    private String receptionistTimings;
    private int deptId;

	public ReceptionistDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getReceptionistId() {
		return receptionistId;
	}
	public void setReceptionistId(int receptionistId) {
		this.receptionistId = receptionistId;
	}
	public String getReceptionistName() {
		return receptionistName;
	}
	public void setReceptionistName(String receptionistName) {
		this.receptionistName = receptionistName;
	}
	public String getReceptionistEmail() {
		return receptionistEmail;
	}
	public void setReceptionistEmail(String receptionistEmail) {
		this.receptionistEmail = receptionistEmail;
	}
	public int getReceptionistSalary() {
		return receptionistSalary;
	}
	public void setReceptionistSalary(int receptionistSalary) {
		this.receptionistSalary = receptionistSalary;
	}
	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getReceptionistTimings() {
		return receptionistTimings;
	}
	public void setReceptionistTimings(String receptionistTimings) {
		this.receptionistTimings = receptionistTimings;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	
}
