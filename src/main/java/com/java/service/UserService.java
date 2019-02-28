package com.java.service;

import com.java.dto.User;
import com.java.exception.InvalidStateException;

public interface UserService {

	public void insertUser(User u) throws InvalidStateException;
	
	public User getUser(String username, String password);
}
