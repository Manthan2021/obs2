package com.coforge.project.obs.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.Table;

@Entity
@Table(name="transact")
public class Transact {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long tid;
	private String uid;
	private Date date;
	private String recieverid;	
	private Long Sent;
	private Long recieved;
	private Long balance;
	
	public Transact() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Transact(String uid, Date date, String recieverid, Long sent, Long recieved, Long balance) {
		super();
		this.uid = uid;
		this.date = date;
		this.recieverid = recieverid;
		Sent = sent;
		this.recieved = recieved;
		this.balance = balance;
	}




	public Long getTid() {
		return tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRecieverid() {
		return recieverid;
	}

	public void setRecieverid(String recieverid) {
		this.recieverid = recieverid;
	}

	public Long getSent() {
		return Sent;
	}

	public void setSent(Long sent) {
		Sent = sent;
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
	
	
	}
	
	

