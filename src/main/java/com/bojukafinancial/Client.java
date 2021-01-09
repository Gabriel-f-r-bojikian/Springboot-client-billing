package com.bojukafinancial;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Client {
	private @Id @GeneratedValue long clientId;
	private String name;
	private BigDecimal amountDue;
	
	Client() {}
	
	Client(long clientId, String name, BigDecimal amountDue){
		this.clientId = clientId;
		this.name = name;
		this.amountDue = amountDue;
	}
	
	public void setId(long clientId) {
		this.clientId = clientId;
	}

	public long getId() {
		return this.clientId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setAmountDue(BigDecimal amountDue) {
		this.amountDue = amountDue;
	}
	
	public BigDecimal getAmountDue() {
		return this.amountDue;
	}

}
