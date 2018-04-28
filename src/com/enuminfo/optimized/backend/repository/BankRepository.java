/**
 * Optimized Java Swing Application Demo
 * Copyright(c) 2018, enuminfo.com
 */
package com.enuminfo.optimized.backend.repository;

import com.enuminfo.optimized.backend.entity.BankEntity;

/**
 * Bank Repository
 * 
 * @author Kumar
 */
public class BankRepository extends AbstractRepository<BankEntity> {

	public BankRepository() {
		super(BankEntity.class);
	}
}
