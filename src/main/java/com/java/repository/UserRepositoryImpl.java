package com.java.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.java.dto.User;
import com.java.exception.InvalidStateException;

@Repository
public class UserRepositoryImpl implements UserRepository{

	SessionFactory factory;

	{
		Configuration configuration = new Configuration();
		configuration.configure("hibernate-config.xml");
		factory = configuration.buildSessionFactory();
	}
	
	@Override
	public void insertUser(User u) throws InvalidStateException {
		Session session = factory.openSession();
		
		if(session.get(User.class, u.getUsername()) == null) {
			Transaction transaction = session.beginTransaction();
			session.save(u);
			transaction.commit();
			session.close();
		} else {
			session.close();
			throw new InvalidStateException("username is already in the DB");
		}
	}

	@Override
	public User getUser(String username, String password) {
		Session session = factory.openSession();
		Query<User> query= session.createQuery("from User where username = " + username +" and password = " + password, User.class);
		User user= query.uniqueResult();
		return user;
	}

}
