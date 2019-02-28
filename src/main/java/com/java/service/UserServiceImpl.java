package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.User;
import com.java.exception.InvalidStateException;
import com.java.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired UserRepository rep;
	
	@Override
	public void insertUser(User u) throws InvalidStateException {
		rep.insertUser(u);
	}

	@Override
	public User getUser(String username, String password) {
		return rep.getUser(username, password);
	}

}
