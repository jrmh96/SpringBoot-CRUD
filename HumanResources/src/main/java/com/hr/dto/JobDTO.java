package com.hr.dto;

import java.math.BigDecimal;

public class JobDTO implements Comparable<JobDTO>{
	
	private String JobID;
	private String JobTitle;
	private BigDecimal MinSalary;
	private BigDecimal MaxSalary;
	
	
	@Override
	public int compareTo(JobDTO o) {
		return this.JobTitle.compareTo(o.JobTitle);
	}
	
	public String getJobTitle(){
		return JobTitle;
	}
	
	public void setJobTitle(String s){
		this.JobTitle=s;
	}
	
	public String getJobID() {
		return JobID;
	}


	public void setJobID(String jobID) {
		JobID = jobID;
	}


	public BigDecimal getMinSalary() {
		return MinSalary;
	}


	public void setMinSalary(BigDecimal minSalary) {
		MinSalary = minSalary;
	}


	public BigDecimal getMaxSalary() {
		return MaxSalary;
	}


	public void setMaxSalary(BigDecimal maxSalary) {
		MaxSalary = maxSalary;
	}
	
}