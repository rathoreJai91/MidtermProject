package com.medicorps.dto;

import java.time.LocalDate;

public class StaffDto {
    
	private int staffId;
    private String staffName;
    private String staffRole;
    private String staffEmail;
    private String staffTiming;
    private int staffSalary;
    private String deptName;
    private LocalDate dateOfJoining;
    
    public StaffDto() {
    }
	
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getStaffRole() {
		return staffRole;
	}
	public void setStaffRole(String staffRole) {
		this.staffRole = staffRole;
	}
	public String getStaffEmail() {
		return staffEmail;
	}
	public void setStaffEmail(String staffEmail) {
		this.staffEmail = staffEmail;
	}
	public String getStaffTiming() {
		return staffTiming;
	}
	public void setStaffTiming(String staffTiming) {
		this.staffTiming = staffTiming;
	}
	public int getStaffSalary() {
		return staffSalary;
	}
	public void setStaffSalary(int staffSalary) {
		this.staffSalary = staffSalary;
	}
	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
}
