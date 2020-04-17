/**
 * 
 */
package com.enuminfo.optimized.frontend.contoller;

import java.util.ArrayList;
import java.util.List;

import com.enuminfo.optimized.backend.model.Location;
import com.enuminfo.optimized.backend.repository.BaseRepository;
import com.enuminfo.optimized.backend.repository.LocationRepository;
import com.enuminfo.optimized.framework.AbstractDataPageController;
import com.enuminfo.optimized.framework.DataPageView;
import com.enuminfo.optimized.frontend.view.LocationView;

/**
 * @author AKURATI
 */
public class LocationController extends AbstractDataPageController<Location> {
	
	@Override
	public void openFormView(Location model) {
		
	}

	@Override
	public void onAddNew() {
		
	}

	@Override
	public List<Location> getData(String filter, int start, int end) {
		if (filter.equals("")) {
            return getRepository().findAllWithPaging(start, end);
        } else {
			/*
			 * return getRepository().findByColumnWithPaging(with("name", "%" + filter +
			 * "%") .and("pin", "%" + filter + "%").and("city", "%" + filter + "%")
			 * .and("state", "%" + filter + "%").parameters(), start, end);
			 */
        	return new ArrayList<Location>();
        }
	}

	@Override
	public int getDataSize(String filter) {
		if (filter.equals("")) {
            return getRepository().findAll().size();
        } else {
			/*
			 * return getRepository().findByColumn(with("name", "%" + filter + "%")
			 * .and("pin", "%" + filter + "%").and("city", "%" + filter + "%") .and("state",
			 * "%" + filter + "%").parameters()).size();
			 */
        	return new ArrayList<Location>().size();
        }
	}

	@Override
	public String getName() {
		return LocationController.class.getSimpleName();
	}

	@Override
	protected BaseRepository<Location> createRepository() {
		return new LocationRepository();
	}

	@Override
	protected DataPageView<Location> createDataPageView() {
		return new LocationView();
	}
}
