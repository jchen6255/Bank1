package com.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.java.dto.Account;
import com.java.exception.InvalidStateException;
import com.java.service.BankingService;
import com.java.service.CustomerService;


@Controller
public class AccountController {
	
	@Autowired BankingService s;
	@Autowired CustomerService c;
	
	@PostMapping("withdraw")
//	@ModelAttribute Account account,
	public String withdraw(@RequestParam("accountNumber") int accountid, @RequestParam("balance") double withdrawAmount,Model m) {
		try {
			
			s.withdraw(accountid, withdrawAmount);
			m.addAttribute("message",withdrawAmount + " is withdrawed from account " + accountid);
			return "view";
		} catch (InvalidStateException e) {
			m.addAttribute("error", "cannot withdraw");
			return "error";
		}
	}
	
	@PostMapping("deposit")
	public String deposit(@RequestParam("accountNumber") int accountid, @RequestParam("balance") double deposit,Model mv) {
		try {
			s.deposit(accountid, deposit);
		} catch (InvalidStateException e) {
			mv.addAttribute("error", "cannot deposit");
			return "error";
		}
		mv.addAttribute("message", deposit + " is deposited suseccfully");
		return "view";
	}
	
	
	@PostMapping("create")
	public String createAccount(@Valid @ModelAttribute Account account , HttpServletRequest request,Model m) {
//		Account account = new Account();
//		account.setAccountType(accountType);
//		account.setAmount(amount);
		
		String username = (String) request.getSession().getAttribute("username");
		int customerId = c.getCustomerIdByUsername(username);
		account.setCustomerId(customerId);
		s.createAccount(account);
		m.addAttribute("message", "Account is created");
		return "view";
	}
		
	@PostMapping("delete")
	public String deleteAccount(@RequestParam int accountNumber, Model m) {
		
		try {
			s.deleteAccount(accountNumber);
		} catch (InvalidStateException e) {
			
			m.addAttribute("error", "not able to delete");
			return "error";
		}
		
		m.addAttribute("message", "account: " + accountNumber + " is deleted"); 
		return "view";
	}
	
	@PostMapping("transfer")
	public String transferMoney(@RequestParam int fromAccount, @RequestParam int toAccount, @RequestParam double amount, Model m) {
		
		try {
			s.transferMoney(fromAccount, toAccount, amount);
		} catch (InvalidStateException e) {
			m.addAttribute("error", "unable to transfer from " + fromAccount + " to " + toAccount);
		}
		
		m.addAttribute("message", "transfer successfully");
		return "view";
	}
	
	@GetMapping("report")
	public String viewTransactions(@RequestParam int year, @RequestParam int month, Model m) {
		m.addAttribute("reports",s.getReports(year, month));
		return "viewReport";
	}
	
//	@GetMapping("report2")
//	public String viewTransactionsByPage(HttpServletRequest request,@RequestParam int page,Model m) {
////		m.addAttribute("reports",s.getReports(year, month));
//		int year = (int) request.getSession().getAttribute("year");
//		int month = (int) request.getSession().getAttribute("month");
//		s.getAllAccountsByPage(page, year, month, 5);
//		return "viewReport";
//	}
	
	@GetMapping("welcome")
	public String getWelcomePage() {
		return "welcome";
	}
	
	
	
}
