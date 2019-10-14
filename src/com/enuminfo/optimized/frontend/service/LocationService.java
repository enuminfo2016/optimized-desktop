/**
 * 
 */
package com.enuminfo.optimized.frontend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.enuminfo.optimized.frontend.component.ComboBoxItem;
import com.enuminfo.optimized.frontend.model.Location;
import com.enuminfo.optimized.uitl.DataUtil;

/**
 * @author AKURATI
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
		List<Location> locations = new ArrayList<Location>();
		// locations from database
		if (locations.isEmpty())
			locations = DataUtil.locations;
		return locations;
	}

	@Override
	public List<Location> getListWithNamedQuery(Map<String, Object> parameters) {
		List<Location> locations = new ArrayList<Location>();
		// locations from database
		if (locations.isEmpty())
			locations = DataUtil.locations;
		return locations;
	}

	@Override
	public List<Location> getListWithNamedQuery(Map<String, Object> parameters, int start, int end) {
		List<Location> locations = new ArrayList<Location>();
		// locations from database
		if (locations.isEmpty())
			locations = DataUtil.locations;
		return getPagingList(locations, start, end);
	}

	@Override
	public List<Location> getListWithNamedQuery(int start, int end) {
		List<Location> locations = new ArrayList<Location>();
		// locations from database
		if (locations.isEmpty())
			locations = DataUtil.locations;
		return getPagingList(locations, start, end);
	}

	@Override
	public List<ComboBoxItem> getListOfReferences() {
		return null;
	}
	
	private List<Location> getPagingList(List<Location> locations, int start, int end) {
		List<Location> finalList = new ArrayList<Location>();
		if (end > locations.size()) end = locations.size();
		for (int i = start; i < end; i++) {
			finalList.add(locations.get(i));
		}
		return finalList;
	}
}
