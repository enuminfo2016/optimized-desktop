/**
 * 
 */
package com.enuminfo.optimized.backend.repository;

import com.enuminfo.optimized.backend.entity.OrderLineEntity;

/**
 * @author Kumar
 */
public class OrderLineRepository extends AbstractRepository<OrderLineEntity> {

	public OrderLineRepository() {
		super(OrderLineEntity.class);
	}
}
