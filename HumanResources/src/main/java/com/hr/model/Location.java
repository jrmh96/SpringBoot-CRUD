package com.hr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="LOCATION")
public class Location {
	private Long LocationId;
	private String streetAddress;
	private String postalCode;
	private String city;
	private String state;
	private String countryId;
	
	@Id
	@GeneratedValue(generator="LocationSeq")
	@SequenceGenerator(name="LocationSeq", sequenceName="LOCATIONS_SEQ", allocationSize=5)
	@Column(name="LOCATION_ID")
	public Long getLOCATION_ID() {
		return LocationId;
	}

	public void setLOCATION_ID(Long l) {
		this.LocationId=l;
	}
	
	@Column(name="STREET_ADDRESS")
	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	@Column(name="POSTAL_CODE")
	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	@Column(name="CITY")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(name="STATE_PROVINCE")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	@Column(name="COUNTRY_ID")
	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	
}
