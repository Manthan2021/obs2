package com.coforge.project.obs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Passbook")

public class Passbook {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private Long id;
	private Long sent;
	private Long recieved;
	private Long balance;
	private String ContactId;
	
	
	public Passbook() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Passbook(Long sent, Long recieved, Long balance, String contactId) {
		super();
		this.sent = sent;
		this.recieved = recieved;
		this.balance = balance;
		ContactId = contactId;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getSent() {
		return sent;
	}


	public void setSent(Long sent) {
		this.sent = sent;
	}


	public Long getRecieved() {
		return recieved;
	}


	public void setRecieved(Long recieved) {
		this.recieved = recieved;
	}


	public Long getBalance() {
		return balance;
	}


	public void setBalance(Long balance) {
		this.balance = balance;
	}


	public String getContactId() {
		return ContactId;
	}


	public void setContactId(String contactId) {
		ContactId = contactId;
	}
	
	
	

}
