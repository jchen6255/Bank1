//package com.java.repository;
//
//import java.util.List;
//
//import org.hibernate.HibernateException;
//import org.hibernate.Session;
//import org.hibernate.criterion.DetachedCriteria;
//import org.hibernate.query.Query;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Primary;
//import org.springframework.orm.hibernate5.HibernateCallback;
//import org.springframework.orm.hibernate5.HibernateTemplate;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Isolation;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.java.dto.Account;
//import com.java.dto.Payee;
//import com.java.dto.Report;
//import com.java.exception.InvalidStateException;
//
//@Repository
//public class AccountRepositoryImpl2 implements AccountRepository{
//
//	
//	@Autowired HibernateTemplate template;
//	@Transactional(propagation=Propagation.REQUIRED)
//	@Override
//	public void createAccount(Account account) {
//		template.save(account);
//	}
//
//	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
//	@Override
//	public void deleteAccount(int accountid) throws InvalidStateException {
//		Account account = template.get(Account.class, accountid);
//		template.delete(account);
//		
//	}
//
//	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED)
//	@Override
//	public void withdraw(int accountid, double amount) throws InvalidStateException {
//		Account account = template.get(Account.class, accountid);
//		
//		if(account.getAmount()>= amount) {
//			template.execute(new HibernateCallback<Account>() {
//
//				@Override
//				public Account doInHibernate(Session session) throws HibernateException {
//					session.beginTransaction();
//					Query query = session.createQuery(
//						"update Account set version = ?1, amount = ?2 where version = ?3 and accountNumber = ?4");
//					query.setParameter(1, account.getVersion() + 1);
//					query.setParameter(2, account.getAmount() - amount);
//					query.setParameter(3, account.getVersion());
//					query.setParameter(4, accountid);
//					query.executeUpdate();
//					return null;
//				}
//			});
//		}
//	}
//
//	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED)
//	@Override
//	public void deposit(int accountid, double amount) throws InvalidStateException {
//		
//		Account account = template.get(Account.class, accountid);
//		template.bulkUpdate("update Account set version = ? and amount = ? where "
//				+ "version = ? and accountNumber = ?", new Object[] {account.getVersion()+1,
//						account.getAmount()+amount,account.getVersion(),account.getAccountNumber()});
//	}
//
//	@Transactional(isolation=Isolation.READ_COMMITTED)
//	@Override
//	public Account getAccount(int accountid) {
//		System.out.println(template);
//		return template.get(Account.class, accountid);
//		
//	}
//
//	
//	@Override
//	public List<Report> getReports(int year, int month) {
//		return (List<Report>) template.find("from Report where year = ? and month =?", new Object[] {year,month});
//		
//	}
//
//
//	@Transactional(propagation=Propagation.MANDATORY,isolation=Isolation.READ_COMMITTED)
//	@Override
//	public void transferMoney(int fromAccountid, int toAccountid, double amount) throws InvalidStateException {
//		withdraw(fromAccountid, amount);
//		deposit(toAccountid, amount);
//		
//	}
//
//	@Transactional(isolation=Isolation.READ_COMMITTED)
//	@Override
//	public List<Account> getAllAccountsByPage(int pageNumber, int size) {
//		 
//		List<Account> accounts = (List<Account>) template.findByCriteria(DetachedCriteria.forClass(Account.class), (pageNumber-1)*size, size*pageNumber);
//		return accounts;
//	}
//
//	@Override
//	public List<Account> getAccounts(int custId) {
//		return (List<Account>) template.find("from Account where username = " + custId);
//	}
//
//	@Override
//	public List<Payee> getPayees(int accountid) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void insertPayee(Payee payee) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	
//}
