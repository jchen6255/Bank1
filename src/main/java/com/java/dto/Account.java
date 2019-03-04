package com.java.dto;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
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
	

	@OneToMany
	@JoinTable(name="account_payee", joinColumns= {@JoinColumn(name="Account_accountNumber")}, inverseJoinColumns={@JoinColumn(name="Payee_nickname")})

	List<Payee> payees;

}