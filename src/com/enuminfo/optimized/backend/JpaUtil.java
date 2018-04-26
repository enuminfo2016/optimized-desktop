/*
 * Optimized Java Swing Application Demo
 * Copyright(c) 2018, enuminfo.com
 */
package com.enuminfo.optimized.backend;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * JPA Util
 * @author Kumar
 */
public class JpaUtil {

	private static EntityManagerFactory entityManagerFactory;
	
	public JpaUtil() {
		// TODO Auto-generated constructor stub
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		if (entityManagerFactory == null)
			entityManagerFactory = Persistence.createEntityManagerFactory("OptimizedDesktopPU");
		return entityManagerFactory;
	}

	public static void closeEntityManagerFactory() {
		if (entityManagerFactory != null)
			entityManagerFactory.close();
	}

	public static EntityManager getEntityManager() {
		return getEntityManagerFactory().createEntityManager();
	}
}
