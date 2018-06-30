/**
 * 
 */
package com.enuminfo.optimized.frontend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.enuminfo.optimized.backend.entity.LocationEntity;
import com.enuminfo.optimized.backend.repository.LocationRepository;
import com.enuminfo.optimized.frontend.component.ComboBoxItem;
import com.enuminfo.optimized.frontend.model.Location;

/**
 * @author Kumar
 */
public class LocationService extends AbstractService<Location> {

	public LocationService() {
		super(Location.class);
	}

	@Override
	public Object getRepository() {
		return new LocationRepository();
	}

	@Override
	public void add(Location model) {

	}

	@Override
	public void edit(Location model) {

	}

	@Override
	public Location getById(Integer id) {
		return null;
	}

	@Override
	public String getNamedQuery() {
		return LocationEntity.FIND_ALL;
	}

	@Override
	public String getNamedQueryWithFilter() {
		return LocationEntity.FIND_BY_NAME;
	}

	@Override
	public List<Location> getListWithNamedQuery() {
		List<Location> locations = new ArrayList<>();
		((LocationRepository) getRepository()).findWithNamedQuery(getNamedQuery()).forEach(entity -> {
			Location location = new Location();
			location.setId(entity.getId());
			location.setName(entity.getName());
			location.setPin(entity.getPin());
			location.setCity(entity.getCity());
			location.setState(entity.getState());
			locations.add(location);
		});
		return locations;
	}

	@Override
	public List<Location> getListWithNamedQueryAndParameters(Map<String, Object> parameters) {
		List<Location> locations = new ArrayList<>();
		((LocationRepository) getRepository()).findWithNamedQuery(getNamedQueryWithFilter(), parameters)
				.forEach(entity -> {
					Location location = new Location();
					location.setId(entity.getId());
					location.setName(entity.getName());
					location.setPin(entity.getPin());
					location.setCity(entity.getCity());
					location.setState(entity.getState());
					locations.add(location);
				});
		return locations;
	}

	@Override
	public List<Location> getListWithNamedQueryAndParameters(Map<String, Object> parameters, int start, int end) {
		List<Location> locations = new ArrayList<>();
		((LocationRepository) getRepository()).findWithNamedQuery(getNamedQueryWithFilter(), parameters, start, end)
				.forEach(entity -> {
					Location location = new Location();
					location.setId(entity.getId());
					location.setName(entity.getName());
					location.setPin(entity.getPin());
					location.setCity(entity.getCity());
					location.setState(entity.getState());
					locations.add(location);
				});
		return locations;
	}

	@Override
	public List<Location> getListWithNamedQuery(int start, int end) {
		List<Location> locations = new ArrayList<>();
		((LocationRepository) getRepository()).findWithNamedQuery(getNamedQuery(), start, end).forEach(entity -> {
			Location location = new Location();
			location.setId(entity.getId());
			location.setName(entity.getName());
			location.setPin(entity.getPin());
			location.setCity(entity.getCity());
			location.setState(entity.getState());
			locations.add(location);
		});
		return locations;
	}

	@Override
	public List<ComboBoxItem> getListOfReferences() {
		return null;
	}
}