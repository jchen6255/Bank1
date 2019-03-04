//package com.java.config;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter{
//	@Autowired DataSource ds;
//	@Autowired MyUserDetailsService service;
//	
//	@Bean
//	public BCryptPasswordEncoder encoder() {
//		return new BCryptPasswordEncoder(11);
//	}
//	//authentication
//	@Autowired
//	public  void configure(AuthenticationManagerBuilder auth) throws Exception {
//	/*	auth.jdbcAuthentication().dataSource(ds).passwordEncoder(encoder()).usersByUsernameQuery("select username, password, true as enabled  from user_details where username= ?")
//		.authoritiesByUsernameQuery("select username, authority from user_roles where username= ?");*/
//		auth.userDetailsService(service).passwordEncoder(encoder());
//	}
//	
//	public void configure(HttpSecurity http) throws Exception {
//		
//			http
//				.authorizeRequests()
//				.regexMatchers("/transfer.do").hasRole("CUSTOMER")
//				.regexMatchers("/create.do").hasRole("ADMIN")
//					.and()
//				.formLogin().loginPage("index.jsp")
//				.and()
//				.httpBasic();
//		}
//	
//	
//	
//}
