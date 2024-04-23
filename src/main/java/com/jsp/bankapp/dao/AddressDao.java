package com.jsp.bankapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.jsp.bankapp.entity.Address;
import com.jsp.bankapp.util.DatabaseConfig;

public class AddressDao {
EntityManagerFactory entityManagerFactory=DatabaseConfig.getentityManagerFactory();
	
	public Address saveAddress(Address address) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(address);
		entityTransaction.commit();
		return address;
	}
	public Address findAddressById(int id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
	
		return entityManager.find(Address.class, id);
	}
	public List<Address> findAllAccount() {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		return entityManager.createQuery("Select u from Address u").getResultList();
	}
	public Address updateAccount(Address address) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.merge(address);
		entityTransaction.commit();
		return address;
	}
	public void deleteAccount(Address address) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.remove(address);
		entityTransaction.commit();
	}

}
