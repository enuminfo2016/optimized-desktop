/*
 * Optimized Java Swing Application Demo
 * Copyright(c) 2018, enuminfo.com
 */
package com.enuminfo.optimized.backend.repository;

import com.enuminfo.optimized.backend.entity.CategoryEntity;

/**
 * Category Repository
 * 
 * @author Kumar
 */
public class CategoryRepository extends AbstractRepository<CategoryEntity> {

	public CategoryRepository() {
		super(CategoryEntity.class);
	}
}
