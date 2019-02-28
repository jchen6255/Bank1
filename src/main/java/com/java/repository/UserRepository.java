package com.java.repository;

import com.java.dto.User;
import com.java.exception.InvalidStateException;

public interface UserRepository {

	public void insertUser(User u) throws InvalidStateException;
	
	public User getUser(String username, String password);
	
}
