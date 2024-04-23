package com.jsp.bankapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.jsp.bankapp.entity.User;
import com.jsp.bankapp.util.DatabaseConfig;

public class UserDao {
EntityManagerFactory entityManagerFactory=DatabaseConfig.getentityManagerFactory();
	
	public User saveUser(User user) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		return user;
	}
	public User findUserById(int id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
	
		return entityManager.find(User.class, id);
	}
	public List<User> findAllUser() {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		return entityManager.createQuery("Select u from User u").getResultList();
	}
	public User updateUser(User user) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.merge(user);
		entityTransaction.commit();
		return user;
	}
	public void deleteUser(User user) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.remove(user);
		entityTransaction.commit();
	}
}
