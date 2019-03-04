package com.java.config;


import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ComponentScan("com.java")
//@EnableJpaRepositories(basePackages="com.java.repository")
@EnableWebMvc
@Configuration
public class JavaConfig implements WebMvcConfigurer{

	@Bean
	public ViewResolver resolver() {
		return new InternalResourceViewResolver("/", ".jsp");
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer configurer() {
		PropertySourcesPlaceholderConfigurer cfg= new PropertySourcesPlaceholderConfigurer();
		/*cfg.setLocation(new ClassPathResource("database.properties"));*/
		return cfg;
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
