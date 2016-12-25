package com.hr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name="JOBS")
public class Job {
	private String JobID;
	private String JobTitle;
	private BigDecimal MinSalary;
	private BigDecimal MaxSalary;
	
	@Id
	@Column(name="JOB_ID")
	public String getJobID() {
		return JobID;
	}
	public void setJobID(String jobID) {
		JobID = jobID;
	}
	
	@Column(name="JOB_TITLE")
	public String getJobTitle() {
		return JobTitle;
	}
	public void setJobTitle(String jobTitle) {
		JobTitle = jobTitle;
	}
	
	@Column(name="MIN_SALARY")
	public BigDecimal getMinSalary() {
		return MinSalary;
	}
	public void setMinSalary(BigDecimal minSalary) {
		MinSalary = minSalary;
	}
	
	@Column(name="MAX_SALARY")
	public BigDecimal getMaxSalary() {
		return MaxSalary;
	}
	public void setMaxSalary(BigDecimal maxSalary) {
		MaxSalary = maxSalary;
	}
		
}
