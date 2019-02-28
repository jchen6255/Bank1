package com.java.client;

import com.java.repository.AccountRepositoryImpl;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AccountRepositoryImpl repository = new AccountRepositoryImpl();
//		System.out.println(repository.getAccounts());
//		System.out.println(repository.getAccountLowerThan(500));
//		System.out.println(repository.getSum());
		
		System.out.println(repository.getAllAccounts());
		System.out.println(repository.getAccountLowerThanX(500));
		System.out.println(repository.getSumCriteria());
		
	}

}
