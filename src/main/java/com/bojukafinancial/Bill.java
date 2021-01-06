package com.bojukafinancial;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class Bill {
	
	@Getter @Setter private String billId;
	@Getter @Setter private BigDecimal amount;
	@Getter private boolean isPaid;
	private LocalDate dueDate;
	
	Bill(String billId, BigDecimal amount, String dueDate){
		this.billId = billId;
		this.amount = amount;
		this.dueDate = LocalDate.parse(dueDate);
		this.isPaid = false;
	}
	
	public LocalDate getDueDate() { 
		return this.dueDate; 
	}
	
	public void setDueDate(String newDueDate) {
		this.dueDate = LocalDate.parse(newDueDate);
	}
	
	public void payBill() {
		this.isPaid = true;
	}
	
}
