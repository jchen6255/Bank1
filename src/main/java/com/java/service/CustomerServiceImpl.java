package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.Customer;
import com.java.exception.InvalidStateException;
import com.java.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired CustomerRepository rep;
	
	
	@Override
	public void insertCustomer(Customer customer) throws InvalidStateException {
		rep.insertCustomer(customer);	
	}

	@Override
	public Customer getCustomerById(int id) {
		return rep.getCustomerById(id);
	}
	
	@Override
	public int getCustomerIdByUsername(String username) {
		return rep.getCustomerIdByUsername(username);
	}

}
