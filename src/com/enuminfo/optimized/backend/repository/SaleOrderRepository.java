/**
 * 
 */
package com.enuminfo.optimized.backend.repository;

import com.enuminfo.optimized.backend.entity.SaleOrderEntity;

/**
 * @author Kumar
 */
public class SaleOrderRepository extends AbstractRepository<SaleOrderEntity> {

	public SaleOrderRepository() {
		super(SaleOrderEntity.class);
	}
}
