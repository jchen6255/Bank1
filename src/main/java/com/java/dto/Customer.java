package com.java.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	@NotEmpty
	String firstName;
	@NotEmpty
	String lastName;
	@NotEmpty
	String gender;
	@Range(min=10, max=150)
	int age;
	@NotEmpty
	String street;
	@NotEmpty
	String city;
	@NotEmpty
	String state;
	@NotEmpty
	String zip;
	String phone;
	String email;
	String username;
	
//	@OneToMany(mappedBy="customer")
//	List<Account> accounts;
	
	
	
}
