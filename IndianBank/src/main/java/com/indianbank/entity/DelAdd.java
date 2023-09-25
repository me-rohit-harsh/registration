package com.indianbank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="delivery_address")
public class DelAdd {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long pincode;
	private String street;
	private String state;
	private final String country = "India";

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public DelAdd(Long id, Long pincode, String street, String state) {
		super();
		this.id = id;
		this.pincode = pincode;
		this.street = street;
		this.state = state;
	}

	public DelAdd() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DelAdd [id=" + id + ", pincode=" + pincode + ", street=" + street + ", state=" + state + ", country="
				+ country + "]";
	}

}
