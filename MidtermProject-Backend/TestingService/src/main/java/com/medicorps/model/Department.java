package com.medicorps.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity(name = "department")
public class Department {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dept_id")
    private int deptId;
    private String deptName;
    private int noOfEmps;
    
    @OneToMany(mappedBy = "department" , cascade = CascadeType.ALL)
    private List<Doctor> doctors;
    
    @OneToMany(mappedBy = "department" , cascade = CascadeType.ALL)
    private List<Receptionist> receptionists;
    
    @OneToMany(mappedBy = "department" , cascade = CascadeType.ALL)
    private List<Staff> staff;
    
    @OneToMany(mappedBy = "department" , cascade = CascadeType.ALL)
    private List<Patient> patients;
    
    @OneToMany(mappedBy = "department" , cascade = CascadeType.ALL)
    private List<Appointment> appointments;
     
    public Department() {
    }

    public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getNoOfEmps() {
        return noOfEmps;
    }

    public void setNoOfEmps(int noOfEmps) {
        this.noOfEmps = noOfEmps;
    }

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public List<Receptionist> getReceptionists() {
		return receptionists;
	}

	public void setReceptionists(List<Receptionist> receptionists) {
		this.receptionists = receptionists;
	}

	public List<Staff> getStaff() {
		return staff;
	}

	public void setStaff(List<Staff> staff) {
		this.staff = staff;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

}
