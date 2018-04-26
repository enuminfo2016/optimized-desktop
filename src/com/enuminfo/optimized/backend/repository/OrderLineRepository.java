/**
 * Optimized Java Swing Application Demo
 * Copyright(c) 2018, enuminfo.com
 */
package com.enuminfo.optimized.backend.repository;

import com.enuminfo.optimized.backend.entity.OrderLineEntity;

/**
 * Order Line Repository
 * @author Kumar
 */
public class OrderLineRepository extends AbstractRepository<OrderLineEntity> {

	public OrderLineRepository() {
		super(OrderLineEntity.class);
	}
}
