/**
 * 
 */
package com.enuminfo.optimized.frontend.contoller;

import java.util.ArrayList;
import java.util.List;

import com.enuminfo.optimized.backend.model.Country;
import com.enuminfo.optimized.backend.repository.BaseRepository;
import com.enuminfo.optimized.backend.repository.CountryRepository;
import com.enuminfo.optimized.framework.AbstractDataPageController;
import com.enuminfo.optimized.framework.DataPageView;
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
            return getRepository().findAllWithPaging(start, end);
        } else {
            // return getRepository().findByColumnWithPaging(with("name", "%" + filter + "%").parameters(), start, end);
        	return new ArrayList<Country>();
        }
	}

	@Override
	public int getDataSize(String filter) {
		if (filter.equals("")) {
            return getRepository().findAll().size();
        } else {
            //return getRepository().findByColumn(with("code", "%" + filter + "%").parameters()).size();
        	return new ArrayList<Country>().size();
        }
	}

	@Override
	public String getName() {
		return CountryController.class.getSimpleName();
	}

	@Override
	protected BaseRepository<Country> createRepository() {
		return new CountryRepository();
	}

	@Override
	protected DataPageView<Country> createDataPageView() {
		return new CountryView();
	}
}
