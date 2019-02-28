package com.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class loginController {

	@PostMapping("login")
	public String login(HttpServletRequest req, Model m) {
		String username = req.getParameter("username");
		String pwd = req.getParameter("pwd");
		
		if(username.equals("admin") && pwd.equals("admin")) {
			HttpSession session = req.getSession();
			session.setAttribute("username", username);
			return "welcome";
		}
		
		m.addAttribute("error", "username or password is incorret");
		return "index";
	}
	
}
