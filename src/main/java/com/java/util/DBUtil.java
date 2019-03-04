package com.java.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class DBUtil {

	private static SessionFactory factory;
	
	static {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate-config.xml");
		factory = cfg.buildSessionFactory(); 
	}
	
	
	public static SessionFactory getSessionFactory() {
		return factory;
	} 
	
}
