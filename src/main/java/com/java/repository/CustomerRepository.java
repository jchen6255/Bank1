package com.java.repository;

import com.java.dto.Customer;
import com.java.exception.InvalidStateException;

public interface CustomerRepository {

	public void insertCustomer(Customer customer) throws InvalidStateException;
	public Customer getCustomerById(int id);
	public int getCustomerIdByUsername(String username);

}
