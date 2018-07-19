/**
 * 
 */
package com.enuminfo.optimized.frontend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	public List<Location> getListWithNamedQuery() {
		List<Location> locations = new ArrayList<>();
		return locations;
	}

	@Override
	public List<Location> getListWithNamedQueryAndParameters(Map<String, Object> parameters) {
		List<Location> locations = new ArrayList<>();
		return locations;
	}

	@Override
	public List<Location> getListWithNamedQueryAndParameters(Map<String, Object> parameters, int start, int end) {
		List<Location> locations = new ArrayList<>();
		return locations;
	}

	@Override
	public List<Location> getListWithNamedQuery(int start, int end) {
		List<Location> locations = new ArrayList<>();
		return locations;
	}

	@Override
	public List<ComboBoxItem> getListOfReferences() {
		return null;
	}
}
