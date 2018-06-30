/**
 * 
 */
package com.enuminfo.optimized.backend.repository;

import com.enuminfo.optimized.backend.entity.BankEntity;

/**
 * @author Kumar
 */
public class BankRepository extends AbstractRepository<BankEntity> {

	public BankRepository() {
		super(BankEntity.class);
	}
}
