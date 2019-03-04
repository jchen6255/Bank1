package com.java.repository;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.java.dto.Report;
import com.java.dto.User;
import com.java.exception.InvalidStateException;
import com.java.util.DBUtil;

@Repository
public class UserRepositoryImpl implements UserRepository{

	SessionFactory factory = DBUtil.getSessionFactory();
	
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
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.idEq(username));
		criteria.add(Restrictions.eq("password", password));
		User u = (User) criteria.uniqueResult();
		session.close();
		return u;
	}

}
