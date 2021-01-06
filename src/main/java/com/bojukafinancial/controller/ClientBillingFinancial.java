package com.bojukafinancial.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientBillingFinancial {
	
	LocalDate dueDate = LocalDate.parse("2021-02-05");
	BigDecimal amountDue = new BigDecimal("100");
	BigDecimal interestRate = new BigDecimal("1.01");

	
	@GetMapping
	public String calculateBill(@RequestParam(name = "payDate") String payDate,
								@RequestParam(name = "amount") String amount) {
		
		return calculaJuros(payDate, amount);
	}
	
	
	
	private String calculaJuros(String dataPagamento, String valor) {
		int interestPower = 0;
		
		if (ChronoUnit.DAYS.between(LocalDate.now(), LocalDate.parse(dataPagamento)) < 0) { interestPower++; }
		
		if (ChronoUnit.DAYS.between(LocalDate.now(), LocalDate.parse(dataPagamento)) < -3) { interestPower++; }
		
		if (ChronoUnit.DAYS.between(LocalDate.now(), LocalDate.parse(dataPagamento)) < -5) { interestPower++; }
		
		return amountDue.multiply(interestRate.pow(interestPower)).toString();
	}

}
