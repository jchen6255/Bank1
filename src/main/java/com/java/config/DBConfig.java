//package com.java.config;
//
//import java.io.IOException;
//import java.util.Properties;
//
//import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
//import org.flywaydb.core.Flyway;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.orm.hibernate5.HibernateTemplate;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import com.java.dto.Account;
//import com.java.dto.Customer;
//import com.java.dto.Report;
//import com.java.dto.User;
//
//@Configuration
//@PropertySource(value="classpath:/database.properties")
//@EnableTransactionManagement(proxyTargetClass=false)
//public class DBConfig {
//	
//	
//	@Autowired Environment env;
//	
//	@Bean
//	public BasicDataSource dataSource() {
//		BasicDataSource ds= new BasicDataSource();
//		ds.setUrl(env.getProperty("jdbc.url"));
//		ds.setUsername(env.getProperty("jdbc.username"));
//		ds.setPassword(env.getProperty("jdbc.password"));
//		ds.setDriverClassName(env.getProperty("jdbc.driverClassName"));
//		ds.setDefaultAutoCommit(false);
//		return ds;
//	}
//	
//	
//	@Bean
//	public JdbcTemplate template() {
//		return new JdbcTemplate(dataSource());
//	}
//	
//	@Bean("tm")
//	public DataSourceTransactionManager transactionManager() {
//		DataSourceTransactionManager tx= new DataSourceTransactionManager(dataSource());
//		return tx;
//	}
//	
//	@SuppressWarnings("deprecation")
//	@Bean(initMethod="migrate")
//	public Flyway flyway() {
//		Flyway flyway= new Flyway();
//		flyway.setBaselineOnMigrate(true);
//		flyway.setDataSource(dataSource());
//		flyway.setLocations("classpath:/migration");
//		return flyway;
//	}
//	
//	
//	@Bean
//	public SessionFactory  factory() throws IOException {
//		LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
//		bean.setDataSource(dataSource());
//		bean.setAnnotatedClasses(Account.class,Customer.class,Report.class,User.class);
//		Properties hibernateProperties = new Properties();
//		//hibernateProperties.setProperty(org.hibernate.cfg.Environment.HBM2DDL_AUTO, "create");
//		hibernateProperties.setProperty(org.hibernate.cfg.Environment.SHOW_SQL, "true");
//		hibernateProperties.setProperty(org.hibernate.cfg.Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
//		bean.setHibernateProperties(hibernateProperties);
//		bean.afterPropertiesSet();
//		return bean.getObject();
//	}
//	
//	@Bean
//	public HibernateTemplate hibernateTemplate() throws IOException {
//		return new HibernateTemplate(factory());
//	}
//	
//	@Bean("HibernateTxManager")
//	public HibernateTransactionManager transactionManager1() throws IOException {
//		return new HibernateTransactionManager(factory());
//	}
//	
//	
//	
//	
//
//}
