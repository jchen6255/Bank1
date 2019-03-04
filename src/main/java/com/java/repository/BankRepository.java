package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.dto.Account;

public interface BankRepository extends JpaRepository<Account,Integer>{
	
}
