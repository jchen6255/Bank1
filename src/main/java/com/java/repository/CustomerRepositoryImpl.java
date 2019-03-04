package com.java.repository;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.java.dto.Customer;
import com.java.exception.InvalidStateException;
import com.java.util.DBUtil;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{

	SessionFactory factory = DBUtil.getSessionFactory();
	
	@Override
	public void insertCustomer(Customer customer) throws InvalidStateException {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(customer);
		} catch (Exception e) {
			throw new InvalidStateException("Error Inserting for " + customer);
		}
		
		transaction.commit();
		session.close();
	}

	@Override
	public Customer getCustomerById(int id) {
		Session session = factory.openSession();
		Customer customer = session.get(Customer.class, id);
		session.close();
		return customer;
	}
	

	@Override
	public int getCustomerIdByUsername(String username) {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.add(Restrictions.eq("username", username));
		criteria.setProjection(Projections.property("id"));
		int customerId = (Integer) criteria.uniqueResult();
		session.close();
		return customerId;
	}

}
