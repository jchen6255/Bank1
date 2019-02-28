package com.java.config;

import java.util.Locale;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ComponentScan("com.java")
@EnableWebMvc
@Configuration
@PropertySource(value="classpath:database.properties")
//@EnableTransactionManagement(proxyTargetClass=false)
public class JavaConfig implements WebMvcConfigurer{

	@Autowired Environment env;
	@Bean
	public ViewResolver resolver() {
		return new InternalResourceViewResolver("/", ".jsp");
	}
	
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource ds= new BasicDataSource();
		ds.setUrl(env.getProperty("jdbc.url"));
		System.out.println(env.getProperty("url"));
		ds.setUsername(env.getProperty("jdbc.username"));
		ds.setPassword(env.getProperty("jdbc.password"));
		ds.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		ds.setDefaultAutoCommit(false);
		return ds;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer configurer() {
		PropertySourcesPlaceholderConfigurer cfg= new PropertySourcesPlaceholderConfigurer();
		/*cfg.setLocation(new ClassPathResource("database.properties"));*/
		return cfg;
	}
	
	
	@SuppressWarnings("deprecation")
	@Bean(initMethod="migrate")
	public Flyway flyway() {
		Flyway flyway= new Flyway();
		flyway.setBaselineOnMigrate(true);
		flyway.setDataSource(dataSource());
		flyway.setLocations("classpath:/migration");
		return flyway;
	}
	
	
	@Bean("messageSource")
	public MessageSource getMessageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("welcome");
		return messageSource;
	}
	
	@Bean("interceptor")
	public LocaleChangeInterceptor interceptor() {
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("language");
		return interceptor;
	}
	
	@Bean("localeResolver")
	public LocaleResolver resolver1() {
		SessionLocaleResolver resolver = new SessionLocaleResolver();
		return resolver;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor());
	}
	
	
	
	
}
