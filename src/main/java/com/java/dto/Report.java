package com.java.dto;


import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Report {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	int reportId;
	
	int accountNumnber;
	
	Date reportDate;
	
	double moneyFlow;
	
	int month;
	
	int year;
	
	public Report(){}
	
	public Report(int accountNumber, double moneyFlow) {
		this.accountNumnber = accountNumber;
		this.moneyFlow = moneyFlow;
		this.reportDate =  Date.valueOf(LocalDate.now());
		this.month = LocalDate.now().getMonthValue();
		this.year = LocalDate.now().getYear();
	}
	
	
	
	@Override
	public String toString() {
		return "{ Account Number: "+ accountNumnber + ", Date: " + reportDate + ", Amount: " + moneyFlow + "}";
	}
	
}
