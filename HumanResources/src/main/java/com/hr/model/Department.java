package com.hr.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.google.common.collect.Lists;

@Entity
@Table(name="DEPARTMENTS")
public class Department {
	
	private String DepartmentName;
	private Employees Manager;
	private Long Location_ID;
	private Long departmentId;
	private List<Employees> deptEmployees = Lists.newArrayList();
	

	@Id
	@GeneratedValue(generator="DepartmentPKSequence")
    @SequenceGenerator(name="DepartmentPKSequence",sequenceName="DEPARTMENTS_SEQ", allocationSize=5) 
	@Column(name="DEPARTMENT_ID")
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	
	@Column(name="DEPARTMENT_NAME")
	public String getDepartmentName(){
		return DepartmentName;
	}
	public void setDepartmentName(String name){
		this.DepartmentName=name;
	}
	
	//location_id
	@Column(name="LOCATION_ID")
	public Long getLocationId(){
		return Location_ID;
	}
	public void setLocationId(Long id){
		this.Location_ID=id;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="MANAGER_ID")
	@JsonBackReference
	public Employees getManager() {
		return Manager;
	}
	public void setManager(Employees manager) {
		Manager = manager;
	}
	
	@OneToMany(cascade = CascadeType.ALL)
	@JsonBackReference
	public List<Employees> getDeptEmployees() {
		return deptEmployees;
	}
	public void setDeptEmployees(List<Employees> deptEmployees) {
		this.deptEmployees = deptEmployees;
	}

}
