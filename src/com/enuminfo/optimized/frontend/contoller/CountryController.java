/**
 * 
 */
package com.enuminfo.optimized.frontend.contoller;

import static com.enuminfo.optimized.frontend.service.QueryParameter.with;

import java.util.List;

import com.enuminfo.optimized.frontend.framework.AbstractDataPageController;
import com.enuminfo.optimized.frontend.framework.DataPageView;
import com.enuminfo.optimized.frontend.model.Country;
import com.enuminfo.optimized.frontend.service.AbstractService;
import com.enuminfo.optimized.frontend.service.CountryService;
import com.enuminfo.optimized.frontend.view.CountryView;

/**
 * @author AKURATI
 */
public class CountryController extends AbstractDataPageController<Country> {
	
	@Override
	public void openFormView(Country model) {
		
	}

	@Override
	public void onAddNew() {
		
	}

	@Override
	public List<Country> getData(String filter, int start, int end) {
		if (filter.equals("")) {
            return getService().getListWithNamedQuery(start, end);
        } else {
            return getService().getListWithNamedQuery(with("name", "%" + filter + "%").parameters(), start, end);
        }
	}

	@Override
	public int getDataSize(String filter) {
		if (filter.equals("")) {
            return getService().getListWithNamedQuery().size();
        } else {
            return getService().getListWithNamedQuery(with("code", "%" + filter + "%").parameters()).size();
        }
	}

	@Override
	public String getName() {
		return CountryController.class.getSimpleName();
	}

	@Override
	protected AbstractService<Country> createService() {
		return new CountryService();
	}

	@Override
	protected DataPageView<Country> createDataPageView() {
		return new CountryView();
	}
}
