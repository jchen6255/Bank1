package com.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.dto.Account;
import com.java.dto.Customer;
import com.java.dto.User;
import com.java.exception.InvalidStateException;
import com.java.service.CustomerService;
import com.java.service.UserService;

@Controller
public class SignUpController {
	
	
	@Autowired UserService uService; 
	@Autowired CustomerService cService;

	@PostMapping("signup")
	public String signUp(HttpServletRequest req, Model m) {
		String pwd = req.getParameter("pwd");
		String cpwd = req.getParameter("cpwd");
		if(!pwd.equals(cpwd)) {
			m.addAttribute("error", "Confirm password does not match your password");
			return "signup";
		} 
		
		String username = req.getParameter("username");
		String type = req.getParameter("type");
		User user = new User(username,pwd,type);
		
		try {
			uService.insertUser(user);
			System.out.println("99999");
			HttpSession session = req.getSession();
			System.out.println("2222222");
			session.setAttribute("username", username);
			System.out.println("0000000000");
			return "register";
		} catch (InvalidStateException e) {
			m.addAttribute("error", "username is already in DB");
			return "signup";
		}
		
	}
	
	
	@PostMapping("register")
	public String register(@Valid @ModelAttribute Customer customer, HttpServletRequest request, Model m) {
		String username = (String) request.getSession().getAttribute("username");
		System.out.println("username : " + username);
		customer.setUsername(username);
		
		try {
			cService.insertCustomer(customer);
			return "welcome";
		} catch (InvalidStateException e) {
			m.addAttribute("error", "Enter valid Informations");
			return "register";
		}
		
	}
	
}
