package kk.webtestspring.domain.beans;

import kk.webtestspring.entity.beans.BaseEntity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="address")
public class Address extends BaseEntity {
	
	private static final long serialVersionUID = 8466572475235286411L;

	private String firstStreet;
	
	private String secondStreet;
	
	private String town;
	
	private String city;
	
	private String country;
	
	private String zipCode;

	public Address(){}
	
	public String getFirstStreet() {
		return firstStreet;
	}

	public void setFirstStreet(String firstStreet) {
		this.firstStreet = firstStreet;
	}

	public String getSecondStreet() {
		return secondStreet;
	}

	public void setSecondStreet(String secondStreet) {
		this.secondStreet = secondStreet;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}
