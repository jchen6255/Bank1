package com.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.dto.User;
import com.java.repository.AccountRepository;
import com.java.service.BankingService;
import com.java.service.CustomerService;
import com.java.service.UserService;

@Controller
public class loginController {

	
	@Autowired UserService service;
	@Autowired CustomerService custService;
	@Autowired BankingService bankService;
	@PostMapping("login")
	public String login(HttpServletRequest req, Model m) {
		String username = req.getParameter("username");
		String pwd = req.getParameter("pwd");
		User user = service.getUser(username, pwd);
		
		if(user!=null) {
			HttpSession session = req.getSession();
			session.setAttribute("username", username);
			int custId = custService.getCustomerIdByUsername(username);
			System.out.println(custId);
			m.addAttribute("accountInfo", bankService.getAccounts(custId));
			System.out.println(bankService.getAccounts(custId));
			
			return "welcome";
		}
		
		m.addAttribute("error", "username or password is incorret");
		return "index";
	}
	
}
