package kk.webtestspring.domain.beans;

import kk.webtestspring.entity.beans.BaseEntity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="patient")
public class Patient extends BaseEntity{
	
	private static final long serialVersionUID = -1645225063304486186L;

	private String firstName;
	
	private String lastName;
	
	private String dateOfBirth;
	
	private String gender;
	
	private Contact contact;
	
	public Patient(){}

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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
