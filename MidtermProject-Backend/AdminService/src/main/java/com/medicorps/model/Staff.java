package com.medicorps.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Staff {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int staffId;
    private String staffName;
    private String staffRole;
    private String staffEmail;
    private String staffTiming;
    private int staffSalary;
    private LocalDate dateOfJoining;

    @ManyToOne
    @JoinColumn(name = "dept_id", referencedColumnName = "dept_id")
    private Department department;
    
    public Staff() {
    }
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
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
