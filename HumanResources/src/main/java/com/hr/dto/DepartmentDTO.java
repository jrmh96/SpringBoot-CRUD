package com.hr.dto;

public class DepartmentDTO implements Comparable<DepartmentDTO>{
	private String deptName;
	private Long ManagerID;
	private Long LocationID;
	private Long DepartmentID;
	
	public String getDeptName(){
		return this.deptName;
	}
	
	public void setDeptName(String name){
		this.deptName=name;
	}
	
	public Long getManagerID() {
		return ManagerID;
	}

	public void setManagerID(Long managerID) {
		ManagerID = managerID;
	}

	public Long getLocationID() {
		return LocationID;
	}

	public void setLocationID(Long locationID) {
		LocationID = locationID;
	}

	public Long getDepartmentID() {
		return DepartmentID;
	}

	public void setDepartmentID(Long departmentID) {
		DepartmentID = departmentID;
	}
	
	@Override
	public int compareTo(DepartmentDTO o) {
		return this.deptName.compareTo(o.deptName);
	}

	
}
