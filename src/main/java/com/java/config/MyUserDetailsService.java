//package com.java.config;
//
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//@Component
//public class MyUserDetailsService implements UserDetailsService{
//	
//	@Autowired JdbcTemplate template;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		UserDetail details=template.queryForObject("select u.username as username, u.password as password, true, r.authority as roles from user_details u, user_roles r"
//				+ " where u.username=? and r.username = u.username ",new Object[] {username},UserDetail.class);
//		
//		return new User(details.getUsername(), details.getPassword(), details.getAuthorities().stream().map(x-> new SimpleGrantedAuthority(x)).collect(Collectors.toList()));
//	}
//
//}
