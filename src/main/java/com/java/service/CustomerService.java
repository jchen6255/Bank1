package com.java.service;

import com.java.dto.Customer;
import com.java.exception.InvalidStateException;

public interface CustomerService {
	
	public void insertCustomer(Customer customer) throws InvalidStateException;
	public Customer getCustomerById(int id);
	public int getCustomerIdByUsername(String username);

}
