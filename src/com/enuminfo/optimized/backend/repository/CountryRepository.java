/*
 * 
 */
package com.enuminfo.optimized.backend.repository;

import com.enuminfo.optimized.backend.entity.CountryEntity;

/**
 * @author Kumar
 */
public class CountryRepository extends AbstractRepository<CountryEntity> {

	public CountryRepository() {
		super(CountryEntity.class);
	}
}
