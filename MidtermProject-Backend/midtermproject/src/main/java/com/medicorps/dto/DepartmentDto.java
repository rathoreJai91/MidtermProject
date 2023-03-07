package com.medicorps.dto;

public class DepartmentDto {
    
    private int deptId;
    private String deptName;
    private int noOfEmps;

    public DepartmentDto() {
    }

    public DepartmentDto(int deptId, String deptName, int noOfEmps) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.noOfEmps = noOfEmps;
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
}
