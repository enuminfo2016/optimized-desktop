/**
 * Optimized Java Swing Application Demo
 * Copyright(c) 2018, enuminfo.com
 */
package com.enuminfo.optimized.backend.repository;

import com.enuminfo.optimized.backend.entity.CustomerEntity;

/**
 * Customer Repository
 * 
 * @author Kumar
 */
public class CustomerRepository extends AbstractRepository<CustomerEntity> {

	public CustomerRepository() {
		super(CustomerEntity.class);
	}
}
