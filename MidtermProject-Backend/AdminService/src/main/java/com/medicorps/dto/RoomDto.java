package com.medicorps.dto;

public class RoomDto {

    private int roomId;
    private int noOfBeds;
    private int vacantBeds;
    private int deptId;
    
    public RoomDto() {
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getNoOfBeds() {
        return noOfBeds;
    }

    public void setNoOfBeds(int noOfBeds) {
        this.noOfBeds = noOfBeds;
    }

    public int getVacantBeds() {
        return vacantBeds;
    }

    public void setVacantBeds(int vacantBeds) {
        this.vacantBeds = vacantBeds;
    }

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
}
