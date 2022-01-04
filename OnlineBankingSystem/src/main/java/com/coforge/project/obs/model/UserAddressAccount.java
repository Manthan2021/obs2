package com.coforge.project.obs.model;

import java.util.Date;

public class UserAddressAccount {
	private Long id;
	private String email;
	private String firstname;
	private String lastname;
	private String fathername;
	private Date dob;
	private String aadharnumber;
	private String pannumber;
	private String password;
	private String mobilenumber;

	private String country;
	private String state;
	private String city;
	private String street;
	private int pincode;
	
	private String uid;

	public UserAddressAccount(Long id, String email, String firstname, String lastname, String fathername, Date dob,
			String aadharnumber, String pannumber, String password, String mobilenumber, String country, String state,
			String city, String street, int pincode, String uid) {
		super();
		this.id = id;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.fathername = fathername;
		this.dob = dob;
		this.aadharnumber = aadharnumber;
		this.pannumber = pannumber;
		this.password = password;
		this.mobilenumber = mobilenumber;
		this.country = country;
		this.state = state;
		this.city = city;
		this.street = street;
		this.pincode = pincode;
		this.uid = uid;
	}

	public UserAddressAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAadharnumber() {
		return aadharnumber;
	}

	public void setAadharnumber(String aadharnumber) {
		this.aadharnumber = aadharnumber;
	}

	public String getPannumber() {
		return pannumber;
	}

	public void setPannumber(String pannumber) {
		this.pannumber = pannumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}
	
	
}
