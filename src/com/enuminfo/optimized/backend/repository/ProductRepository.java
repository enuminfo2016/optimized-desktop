/**
 * 
 */
package com.enuminfo.optimized.backend.repository;

import com.enuminfo.optimized.backend.entity.ProductEntity;

/**
 * @author Kumar
 */
public class ProductRepository extends AbstractRepository<ProductEntity> {

	public ProductRepository() {
		super(ProductEntity.class);
	}
}
