/*
 * 
 */
package com.enuminfo.optimized.backend.repository;

import com.enuminfo.optimized.backend.entity.CategoryEntity;

/**
 * @author Kumar
 */
public class CategoryRepository extends AbstractRepository<CategoryEntity> {

	public CategoryRepository() {
		super(CategoryEntity.class);
	}
}
