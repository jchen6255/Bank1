package com.java.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		@SuppressWarnings("rawtypes")
		Class[] clazz = new Class[]{JavaConfig.class};
		return clazz;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"*.do"};
	}

}
