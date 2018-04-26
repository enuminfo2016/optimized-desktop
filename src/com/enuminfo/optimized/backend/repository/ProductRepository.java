/**
 * Optimized Java Swing Application Demo
 * Copyright(c) 2018, enuminfo.com
 */
package com.enuminfo.optimized.backend.repository;

import com.enuminfo.optimized.backend.entity.ProductEntity;

/**
 * Product Repository
 * @author Kumar
 */
public class ProductRepository extends AbstractRepository<ProductEntity> {

	public ProductRepository() {
		super(ProductEntity.class);
	}
}
