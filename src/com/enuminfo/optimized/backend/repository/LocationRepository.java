/**
 * 
 */
package com.enuminfo.optimized.backend.repository;

import com.enuminfo.optimized.backend.entity.LocationEntity;

/**
 * @author Kumar
 */
public class LocationRepository extends AbstractRepository<LocationEntity> {

	public LocationRepository() {
		super(LocationEntity.class);
	}
}
