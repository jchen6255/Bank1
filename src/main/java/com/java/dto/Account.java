package com.java.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int accountNumber;
	@NotEmpty
	String accountType;
	@Min(0)
	double amount;
	int version;
	int customerId;
	
//	@ManyToOne
//	Customer customer;
	
	
	
}