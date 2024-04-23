package com.jsp.bankapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.jsp.bankapp.entity.Account;
import com.jsp.bankapp.util.DatabaseConfig;

public class AccountDao {
EntityManagerFactory entityManagerFactory=DatabaseConfig.getentityManagerFactory();
	
	public Account saveAccount(Account account) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(account);
		entityTransaction.commit();
		return account;
	}
	public Account findAccountById(int id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
	
		return entityManager.find(Account.class, id);
	}
	public List<Account> findAllAccount() {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		return entityManager.createQuery("Select u from Account u").getResultList();
	}
	public Account updateAccount(Account account) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.merge(account);
		entityTransaction.commit();
		return account;
	}
	public void deleteAccount(Account account) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.remove(account);
		entityTransaction.commit();
	}
}
