package com.medicorps.dto;

public class PatientDto {
    
    private int patientId;
    private String patientName;
    private int age;
    private Long patientContactNo;
    private String status;
    private String problem;
    private String diagnosis;
    
    public PatientDto() {
    }

    public PatientDto(int patientId, String patientName, int age, Long patientContactNo) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.age = age;
        this.patientContactNo = patientContactNo;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
    
	
//
//	public AppointmentDto getAppointmentDto() {
//		return appointmentDto;
//	}
//
//	public void setAppointmentDto(AppointmentDto appointmentDto) {
//		this.appointmentDto = appointmentDto;
//	}

    
}
