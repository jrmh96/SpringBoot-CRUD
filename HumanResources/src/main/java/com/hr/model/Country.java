package com.hr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Countries")
public class Country{
	
	private String Country_ID;
	private String Name;
	private Long Id;
	
	@Id
	@Column(name="COUNTRY_ID")
	public String getCountry_ID(){
		return Country_ID;
	}
	public void setCountry_ID(String Id){
		this.Country_ID=Id;
	}
	
	@Column(name="COUNTRY_NAME")
	public String getName(){
		return Name;
	}
	public void setName(String name){
		this.Name=name;
	}
	
	@Column(name="REGION_ID")
	public Long getID(){
		return Id;
	}
	public void setID(Long ID){
		this.Id=ID;
	}
}

