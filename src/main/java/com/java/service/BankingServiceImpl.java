package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.java.dto.Account;
import com.java.dto.Report;
import com.java.exception.InvalidStateException;
import com.java.repository.AccountRepository;

@Service
public class BankingServiceImpl implements BankingService{

	@Autowired AccountRepository rep;
	
	@Override
	@Transactional(propagation=Propagation.MANDATORY)
	public void transferMoney(int fromAccountid, int toAccountid, double amount) throws InvalidStateException {
		rep.transferMoney(fromAccountid, toAccountid, amount);
	}
	
	@Override
	public void deposit(int accountid, double amount) throws InvalidStateException {
		rep.deposit(accountid, amount);
	}
	
	@Override
	public void withdraw(int accountid, double amount) throws InvalidStateException {
		rep.withdraw(accountid, amount);
	}
	
	@Override
	public Account getAccount(int accountid) {	
		return rep.getAccount(accountid);
	}

	@Override
	public void createAccount(Account account) {
		rep.createAccount(account);
	}


	@Override
	public void deleteAccount(int accountid) throws InvalidStateException {
		rep.deleteAccount(accountid);
		
	}

	@Override
	public List<Report> getReports(int year, int month) {
		return rep.getReports(year, month);
	}

	@Override
	public List<Account> getAllAccountsByPage(int pageNumber, int size) {
		return rep.getAllAccountsByPage(pageNumber, size);
	}
}