/**
 * 
 */
package com.enuminfo.optimized.backend.repository;

import com.enuminfo.optimized.backend.entity.CustomerEntity;

/**
 * @author Kumar
 */
public class CustomerRepository extends AbstractRepository<CustomerEntity> {

	public CustomerRepository() {
		super(CustomerEntity.class);
	}
}
