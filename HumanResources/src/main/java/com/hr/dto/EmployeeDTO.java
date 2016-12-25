package com.hr.dto;

import java.math.BigDecimal;

public class EmployeeDTO implements Comparable<EmployeeDTO>{
	private Long ID;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String hireDate;
	private String jobID;
	private String jobTitle;
	private BigDecimal salary;
	private BigDecimal CommissionPercent;
	private Long managerID;
	private Long departmentID;
	private String updateLink;
	private String deleteLink;
	
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	public String getJobID() {
		return jobID;
	}
	public void setJobID(String jobID) {
		this.jobID = jobID;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public BigDecimal getCommissionPercent() {
		return CommissionPercent;
	}
	public void setCommissionPercent(BigDecimal commissionPercent) {
		CommissionPercent = commissionPercent;
	}
	public Long getManagerID() {
		return managerID;
	}
	public void setManagerID(Long managerID) {
		this.managerID = managerID;
	}
	public Long getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(Long departmentID) {
		this.departmentID = departmentID;
	}
	public String getUpdateLink() {
		return updateLink;
	}
	public void setUpdateLink(String updateLink) {
		this.updateLink = updateLink;
	}
	public String getDeleteLink() {
		return deleteLink;
	}
	public void setDeleteLink(String deleteLink) {
		this.deleteLink = deleteLink;
	}
	
	public String getFullName(){
		return this.firstName+" "+this.lastName;
	}
	@Override
	public int compareTo(EmployeeDTO other) {
		return this.getFullName().compareTo(other.getFullName());
	}
	
}
