package com.medicorps.dto;

import java.time.LocalDate;

public class AdminDto {
    private int adminId;
    private String name;
    private LocalDate dateOfJoining;
	
    public AdminDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
    
    
}
