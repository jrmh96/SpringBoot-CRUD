package com.hr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name="EMPLOYEES")
public class Employees {
	
	private Long employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String hireDate;
	private BigDecimal salary;
	private BigDecimal CommissionPercent;
	private Employees manager;
	private Department department;
	private Job job;
	


	
	@Column(name="FIRST_NAME")
	public String getFirstName(){
		return firstName;
	}
	public void setFirstName(String fn){
		this.firstName=fn;
	}
	
	@Column(name="LAST_NAME")
	public String getLastName(){
		return this.lastName;
	}
	public void setLastName(String ln){
		this.lastName=ln;
	}
	
	@Column(name="EMAIL")
	public String getEmail(){
		return this.email;
	}
	public void setEmail(String email){
		this.email=email;
	}
	
	@Column(name="PHONE_NUMBER")
	public String getPhoneNumber(){
		return this.phoneNumber;
	}
	public void setPhoneNumber(String phn){
		this.phoneNumber=phn;
	}
	
	@Column(name="HIRE_DATE")
	public String getHireDate(){
		return this.hireDate;
	}
	
	public void setHireDate(String hD){
		this.hireDate=hD;
	}
		
	@Column(name="SALARY")
	public BigDecimal getSalary(){
		return this.salary;
	}
	
	public void setSalary(BigDecimal s){
		this.salary=s;
	}
	
	@Column(name="COMMISSION_PCT")
	public BigDecimal getCommissionPercent(){
		return this.CommissionPercent;
	}
	public void setCommissionPercent(BigDecimal cp){
		this.CommissionPercent=cp;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "JOB_ID")
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DEPARTMENT_ID")
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	@Id
	@SequenceGenerator(name="EmployeeSequence", sequenceName="EMPLOYEES_SEQ", allocationSize=5)
	@GeneratedValue(generator="EmployeeSequence")
	@Column(name="EMPLOYEE_ID")
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MANAGER_ID")
	public Employees getManager() {
		return manager;
	}
	public void setManager(Employees manager) {
		this.manager = manager;
	}
	
}

