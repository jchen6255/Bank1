package com.java.repository;

import java.util.List;

import com.java.dto.Account;
import com.java.dto.Report;
import com.java.exception.InvalidStateException;


public interface AccountRepository {
	
	
	
	public void createAccount(Account account);
	public void deleteAccount(int accountid) throws InvalidStateException;
	public void withdraw(int accountid, double amount) throws InvalidStateException;
	public void deposit(int accountid, double amount) throws InvalidStateException;
	public Account getAccount(int accountid);
	public List<Report> getReports(int year, int month);
	public void transferMoney(int fromAccountid, int toAccountid, double amount) throws InvalidStateException;
	public List<Account> getAllAccountsByPage(int pageNumber, int size);
	
	
}
