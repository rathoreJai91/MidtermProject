package com.medicorps.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Receptionist {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int receptionistId;
    private String receptionistName;
    private String receptionistEmail;
    private int receptionistSalary;
    private LocalDate dateOfJoining;
    private String receptionistTimings;
    
    @ManyToOne
    @JoinColumn(name = "dept_id" , referencedColumnName = "dept_id")
    private Department department;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Receptionist() {
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

	public String getReceptionistEmail() {
		return receptionistEmail;
	}

	public void setReceptionistEmail(String receptionistEmail) {
		this.receptionistEmail = receptionistEmail;
	}
    
    
}
