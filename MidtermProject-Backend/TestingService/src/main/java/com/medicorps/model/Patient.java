package com.medicorps.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "patient")
public class Patient {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientId;
    private String patientName;
    private int age;
    private Long patientContactNo;
    private String status;
    private String problem;
    private String diagnosis;
    
    @OneToMany(mappedBy = "patient" , cascade = CascadeType.ALL)
    private List<Appointment> appointment;
    
    @ManyToOne
    @JoinColumn(name = "docId" , referencedColumnName = "docId")
    private Doctor doctor;
    
    @OneToOne(mappedBy = "patient" , cascade = CascadeType.ALL)
    private Reports report;
    
    @OneToMany(mappedBy = "patient" , cascade = CascadeType.ALL)
    private List<Test> tests;
    
    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;

	public Patient() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getPatientContactNo() {
        return patientContactNo;
    }

    public void setPatientContactNo(Long patientContactNo) {
        this.patientContactNo = patientContactNo;
    }
   
	public List<Appointment> getAppointment() {
		return appointment;
	}

	public void setAppointment(List<Appointment> appointment) {
		this.appointment = appointment;
	}

	public Reports getReport() {
		return report;
	}

	public void setReport(Reports report) {
		this.report = report;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Test> getTests() {
		return tests;
	}

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	
	
}
