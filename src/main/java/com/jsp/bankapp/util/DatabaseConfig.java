package com.jsp.bankapp.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseConfig {
	public static EntityManagerFactory getentityManagerFactory() {
		return Persistence.createEntityManagerFactory("java");
	}
}

