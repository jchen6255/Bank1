//package com.java.service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.stereotype.Service;
//
//import com.java.dto.Account;
//import com.java.dto.Report;
//import com.java.exception.InvalidStateException;
//import com.java.repository.BankRepository;
//
//@Service
//public class BankService implements BankingService{
//
//	@Autowired BankRepository rep;
//	
//	@Override
//	public void transferMoney(int fromAccountid, int toAccountid, double amount) throws InvalidStateException {
//		withdraw(fromAccountid, amount);
//		deposit(toAccountid, amount);
//		
//	}
//
//	@Override
//	public void deposit(int accountid, double amount) throws InvalidStateException {
//		Account account = rep.getOne(accountid);
//		account.setAmount(account.getAmount()+amount);
//		if(account!= null) rep.save(account);
//		
//	}
//
//	@Override
//	public void withdraw(int accountid, double amount) throws InvalidStateException {
//		Account account = rep.getOne(accountid);
//		account.setAmount(account.getAmount()-amount);
//		if(account!= null) rep.save(account);
//		
//	}
//
//	@Override
//	public Account getAccount(int accountid) {
//		return rep.getOne(accountid);
//	}
//
//	@Override
//	public List<Account> getAccounts(int custId) {
//		return null;
//	}
//
//	@Override
//	public void createAccount(Account account) {
//		rep.save(account);
//		
//	}
//
//	@Override
//	public void deleteAccount(int accountid) throws InvalidStateException {
//		rep.deleteById(accountid);
//		
//	}
//
//	@Override
//	public List<Report> getReports(int year, int month) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Account> getAllAccountsByPage(int pageNumber, int size) {
//		// TODO Auto-generated method stub
//		List<Account> accounts = new ArrayList<Account>();
//		rep.findAll(PageRequest.of(pageNumber, size)).forEach(accounts::add);
//		return accounts;
//	}
//
//}
