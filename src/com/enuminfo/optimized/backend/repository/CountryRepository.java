/*
 * Optimized Java Swing Application Demo
 * Copyright(c) 2018, enuminfo.com
 */
package com.enuminfo.optimized.backend.repository;

import com.enuminfo.optimized.backend.entity.CountryEntity;

/**
 * Country Repository
 * 
 * @author Kumar
 */
public class CountryRepository extends AbstractRepository<CountryEntity> {

	public CountryRepository() {
		super(CountryEntity.class);
	}
}
