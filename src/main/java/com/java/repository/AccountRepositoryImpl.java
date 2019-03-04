package com.java.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.java.dto.Account;
import com.java.dto.Payee;
//import com.java.dto.Payee;
import com.java.dto.Report;
import com.java.exception.InvalidStateException;
import com.java.util.DBUtil;

@Repository
@Primary
public class AccountRepositoryImpl implements AccountRepository{

	
	SessionFactory factory = DBUtil.getSessionFactory();
	
	
	@Override
	public void withdraw(int accountid, double amount) throws InvalidStateException {
		
		Session s = factory.openSession();
		Account account = s.get(Account.class, accountid);
		
		if (account != null && account.getAmount() - amount > 0) {
			Transaction tx = s.beginTransaction();

			Query query = s.createQuery("update Account set version = ?1, amount = ?2 where"
					+ " version = ?3 and accountNumber = ?4");
			query.setParameter(1, account.getVersion() + 1);
			query.setParameter(2, account.getAmount() - amount);
			query.setParameter(3, account.getVersion());
			query.setParameter(4, accountid);
			query.executeUpdate();
			Report report = new Report(accountid, -amount);
			s.save(report);
			tx.commit();
			s.close();
		} else {
			throw new InvalidStateException("Cannot withdraw " + (account.getAmount() - amount));
		}
	}

	@Override
	public void deposit(int accountid, double amount) throws InvalidStateException {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Account account = session.get(Account.class, accountid);
		if(account != null) {	

			Query query = session.createQuery("update Account set version = ?1, amount = ?2 where"
					+ " version = ?3 and accountNumber = ?4");
			query.setParameter(1, account.getVersion() + 1);
			query.setParameter(2, account.getAmount() + amount);
			query.setParameter(3, account.getVersion());
			query.setParameter(4, accountid);
			query.executeUpdate();
			Report report = new Report(accountid, amount);
			session.update(account);
			session.save(report);
			tx.commit();
			session.close();
		} else {
			throw new InvalidStateException("Account does not exits");
		}
	}
	
	@Override
	public Account getAccount(int accountid) {
		Session session = factory.openSession();
		Account account = session.get(Account.class, accountid);
		account.getPayees();
		return account;
		
	}

	@Override
	public void createAccount(Account account) {
		Session session = factory.openSession();
		session.save(account);
		Transaction tx = session.beginTransaction();
		tx.commit();
		session.close();
	}

	@Override
	public void deleteAccount(int accountid) throws InvalidStateException {
		
		Session session = factory.openSession();
		Account account = getAccount(accountid);
		if (account != null) {
			session.remove(account);
			Transaction tx = session.beginTransaction();
			tx.commit();
			session.close();
		} else {
			throw new InvalidStateException("Account does not exits");
		}
	}

	
	public List<Account> getAccounts(){
		Session session = factory.openSession();
		Query<Account> query = session.createQuery("from Account",Account.class);
		List<Account> list = query.list();
		 for(Account account: list) {
			 account.getPayees();
		 }
		session.close();
		return list;
	}
	
	public Map<Integer, Double> getAccountLowerThan(double balance){
		Map<Integer, Double> map = new HashMap<Integer, Double>();
		Session session = factory.openSession();
		Query<Account> query = session.createQuery("from Account where amount <" + balance,Account.class);
		List<Account> list = query.list();
		for(Account a:list) {
			map.put(a.getAccountNumber(), a.getAmount());
		}
		session.close();
		return map;
		
	}
	
	public Double getSum() {
		Session session = factory.openSession();
		Query<Double> query = session.createQuery("select sum(amount) from Account",Double.class);
		Double sum = query.uniqueResult();
		return sum;
	}
	
	
	/**
	 *   	Using Criteria 
	 */

	public List<Account> getAllAccounts(){
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Account.class);
		List<Account> list = criteria.list();
		session.close();
		return list;
	}
	
	public Map<Integer, Double> getAccountLowerThanX(double balance){
		Map<Integer, Double> map = new HashMap<Integer, Double>();
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Account.class);
		criteria.add(Restrictions.lt("amount", balance));
		List<Account> list = criteria.list();
		for(Account a:list) {
			map.put(a.getAccountNumber(), a.getAmount());
		}
		session.close();
		return map;
	}
	
	public Double getSumCriteria() {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Account.class);
		criteria.setProjection(Projections.sum("amount"));
		Double sum = (Double) criteria.uniqueResult();
		session.close();
		return sum;
	}
	
	@Override
	public List<Report> getReports(int year, int month) {
		Session session = factory.openSession();
		Query<Report> queery = session.createQuery("from Report where year = " + year + " and month = " + month, Report.class);
		List<Report> reports = queery.list();	
		session.close();
		return reports;
	}
	
	@Override
	public List<Account> getAllAccountsByPage(int pageNumber, int size){
		Session s=factory.openSession();
		Query<Account> query= s.createQuery("from Account", Account.class);
		query.setFirstResult((pageNumber-1)*size);
		query.setMaxResults(size*pageNumber);
		 List<Account> list= query.list();
		 for(Account account: list) {
			 account.getPayees();
		 }
		 s.close();
		 return list;
		}


	@Override
	public void transferMoney(int fromAccountid, int toAccountid, double amount) throws InvalidStateException {
		Session session = factory.openSession();
		Account fromAccount = session.get(Account.class, fromAccountid);
		Account toAccount = session.get(Account.class, toAccountid);
		
		if (fromAccount!=null && toAccount!= null && fromAccount.getAmount() > amount) {
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery("update Account set version = ?1, amount = ?2 where"
					+ " version = ?3 and accountNumber = ?4");
			query.setParameter(1, fromAccount.getVersion() + 1);
			query.setParameter(2, fromAccount.getAmount()-amount);
			query.setParameter(3, fromAccount.getVersion());
			query.setParameter(4, fromAccountid);
			query.executeUpdate();
			Report report = new Report(fromAccountid, -amount);
			session.save(report);
			
			
			Query query2 = session.createQuery("update Account set version = ?1, amount = ?2 where"
					+ " version = ?3 and accountNumber = ?4");
			query2.setParameter(1, toAccount.getVersion() + 1);
			query2.setParameter(2, toAccount.getAmount() + amount);
			query2.setParameter(3, toAccount.getVersion());
			query2.setParameter(4, toAccountid);
			query2.executeUpdate();
			Report report2 = new Report(toAccountid, amount);
			session.save(report2);
			tx.commit();
			session.close();
		} else {
			throw new InvalidStateException("Account does not exits");
		}
		
	}

	@Override
	public List<Account> getAccounts(int custId) {
		Session session = factory.openSession();
		Query<Account> query= session.createQuery("from Account where customerId = " + custId, Account.class);
		List<Account> accounts = query.list();
		
		for(Account account : accounts) {
			System.out.println("+++++=====++++++++++++++++++");
			System.out.println(account.getPayees());
		}
			
		session.close();
		return accounts;
	}

	@Override
	public List<Payee> getPayees(int accountid) {
		Session session = factory.openSession();
		Query<Account> query = session.createQuery("from Account where customerId = " + accountid,Account.class);
		Account account = query.uniqueResult();
		List<Payee> payees = account.getPayees();
		session.close();
		return payees;
	}

	@Override
	public void insertPayee(Payee payee) {
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(payee);
		session.getTransaction().commit();
		session.close();
	}

}
