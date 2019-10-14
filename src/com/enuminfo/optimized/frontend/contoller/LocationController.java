/**
 * 
 */
package com.enuminfo.optimized.frontend.contoller;

import static com.enuminfo.optimized.frontend.service.QueryParameter.with;

import java.util.List;

import com.enuminfo.optimized.frontend.framework.AbstractDataPageController;
import com.enuminfo.optimized.frontend.framework.DataPageView;
import com.enuminfo.optimized.frontend.model.Location;
import com.enuminfo.optimized.frontend.service.AbstractService;
import com.enuminfo.optimized.frontend.service.LocationService;
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
            return getService().getListWithNamedQuery(start, end);
        } else {
        	return getService().getListWithNamedQuery(with("name", "%" + filter + "%")
            		.and("pin", "%" + filter + "%").and("city", "%" + filter + "%")
            		.and("state", "%" + filter + "%").parameters(), start, end);
        }
	}

	@Override
	public int getDataSize(String filter) {
		if (filter.equals("")) {
            return getService().getListWithNamedQuery().size();
        } else {
            return getService().getListWithNamedQuery(with("name", "%" + filter + "%")
            		.and("pin", "%" + filter + "%").and("city", "%" + filter + "%")
            		.and("state", "%" + filter + "%").parameters()).size();
        }
	}

	@Override
	public String getName() {
		return LocationController.class.getSimpleName();
	}

	@Override
	protected AbstractService<Location> createService() {
		return new LocationService();
	}

	@Override
	protected DataPageView<Location> createDataPageView() {
		return new LocationView();
	}
}
