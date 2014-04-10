package kk.webtestspring.domain.beans;

import kk.webtestspring.entity.beans.BaseEntity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="contact")
public class Contact extends BaseEntity {
	
	private static final long serialVersionUID = 7933676441674002787L;

	private String mobile;
	
	private String telephone;
	
	private String dayPhone;
	
	private String nightPhone;
	
	private Address address;
	
	public Contact(){}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getDayPhone() {
		return dayPhone;
	}

	public void setDayPhone(String dayPhone) {
		this.dayPhone = dayPhone;
	}

	public String getNightPhone() {
		return nightPhone;
	}

	public void setNightPhone(String nightPhone) {
		this.nightPhone = nightPhone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
