package com.sms.dataaccess;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class Address {
	private String addressLine1;
	private String addressLine2;
	private String city;
	private int pincode;
	@ManyToOne
	@JoinColumn(name="STATE", insertable=false, updatable=false)
	private State state;
	@Enumerated(EnumType.STRING)
	private AddressType type;

	public enum AddressType {
		PRESENT("PA"), PERMINENT("PR");
		private String type;
		AddressType(String type) {
			this.type  = type;
		}
		public String getType() {
			return this.type;
		}
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public AddressType getType() {
		return type;
	}
	public void setType(AddressType type) {
		this.type = type;
	}
	public Address(String addressLine1, String addressLine2, String city, int pincode, State state, AddressType type) {
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
		this.type = type;
	}
	public Address() {
	}
	
	
	
}
