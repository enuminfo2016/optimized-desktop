/**
 * 
 */
package com.enuminfo.optimized.backend.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.enuminfo.optimized.backend.model.Location;

/**
 * @author AKURATI
 */
public class LocationRepository extends BaseRepository<Location> {

	public LocationRepository() {
		super(Location.class);
	}

	@Override
	protected String getSelectQuery() {
		return "SELECT * FROM tbllocation";
	}

	@Override
	protected String getInsertQuery() {
		return null;
	}

	@Override
	protected String getUpdateQuery() {
		return null;
	}

	@Override
	protected String getDeleteQuery() {
		return null;
	}

	@Override
	protected List<Location> getSpecificValues(List<Object[]> records) {
		List<Location> locations = new ArrayList<Location>();
		for (int i = 0; i < records.size(); i++) {
			Object[] record = records.get(i);
			Location location = new Location();
			location.setId(Integer.parseInt(String.valueOf(record[0])));
			location.setName(String.valueOf(record[1]));
			location.setPin(String.valueOf(record[2]));
			location.setCity(String.valueOf(record[3]));
			location.setState(String.valueOf(record[4]));
			location.setCountry(Integer.parseInt(String.valueOf(record[5])));
			locations.add(location);
		}
		return locations;
	}

	@Override
	protected Map<Integer, Object> putSpecificValues(Location model) {
		return null;
	}
}
