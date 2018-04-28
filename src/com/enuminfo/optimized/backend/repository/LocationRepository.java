/**
 * Optimized Java Swing Application Demo
 * Copyright(c) 2018, enuminfo.com
 */
package com.enuminfo.optimized.backend.repository;

import com.enuminfo.optimized.backend.entity.LocationEntity;

/**
 * Location Repository
 * 
 * @author Kumar
 */
public class LocationRepository extends AbstractRepository<LocationEntity> {

	public LocationRepository() {
		super(LocationEntity.class);
	}
}
