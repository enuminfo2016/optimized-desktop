/**
 * 
 */
package com.enuminfo.optimized.backend.repository;

import java.util.List;
import java.util.Map;

import com.enuminfo.optimized.backend.model.Location;

/**
 * @author AKURATI
 */
public class LocationRepository extends AbstractRepository<Location> {

	public LocationRepository() {
		super(Location.class);
	}

	@Override
	protected List<Location> getSpecificValuesFromDB(List<Object[]> records) {
		return null;
	}

	@Override
	protected String getNamedQuery() {
		return null;
	}

	@Override
	protected String getNamedQueryWithParameters(Map<String, Object> parameters) {
		return null;
	}

	@Override
	protected List<Location> getSpecificValuesFromDBWithPaging(List<Object[]> records, int start, int end) {
		return null;
	}
}
