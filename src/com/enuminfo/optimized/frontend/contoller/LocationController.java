/**
 * 
 */
package com.enuminfo.optimized.frontend.contoller;

import static com.enuminfo.optimized.backend.repository.QueryParameter.with;

import java.util.List;

import com.enuminfo.optimized.backend.model.Location;
import com.enuminfo.optimized.backend.repository.AbstractRepository;
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
        	return getRepository().findByColumnWithPaging(with("name", "%" + filter + "%")
            		.and("pin", "%" + filter + "%").and("city", "%" + filter + "%")
            		.and("state", "%" + filter + "%").parameters(), start, end);
        }
	}

	@Override
	public int getDataSize(String filter) {
		if (filter.equals("")) {
            return getRepository().findAll().size();
        } else {
            return getRepository().findByColumn(with("name", "%" + filter + "%")
            		.and("pin", "%" + filter + "%").and("city", "%" + filter + "%")
            		.and("state", "%" + filter + "%").parameters()).size();
        }
	}

	@Override
	public String getName() {
		return LocationController.class.getSimpleName();
	}

	@Override
	protected AbstractRepository<Location> createRepository() {
		return new LocationRepository();
	}

	@Override
	protected DataPageView<Location> createDataPageView() {
		return new LocationView();
	}
}
