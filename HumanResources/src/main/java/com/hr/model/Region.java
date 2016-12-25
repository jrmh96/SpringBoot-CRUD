package com.hr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="REGIONS")
public class Region {
	private int Id;
	private String RegionName;
	
	@Id
	@Column(name="REGION_ID")
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	@Column(name="REGION_NAME")
	public String getRegionName() {
		return RegionName;
	}
	public void setRegionName(String regionName) {
		RegionName = regionName;
	}
	
	
}