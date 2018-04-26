/**
 * Optimized Java Swing Application Demo
 * Copyright(c) 2018, enuminfo.com
 */
package com.enuminfo.optimized.backend.repository;

import com.enuminfo.optimized.backend.entity.SaleOrderEntity;

/**
 * Sale Order Repository
 * @author Kumar
 */
public class SaleOrderRepository extends AbstractRepository<SaleOrderEntity> {

	public SaleOrderRepository() {
		super(SaleOrderEntity.class);
	}
}
