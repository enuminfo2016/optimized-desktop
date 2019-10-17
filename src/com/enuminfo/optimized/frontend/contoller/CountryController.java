/**
 * 
 */
package com.enuminfo.optimized.frontend.contoller;

import static com.enuminfo.optimized.backend.repository.QueryParameter.with;

import java.util.List;

import com.enuminfo.optimized.backend.model.Country;
import com.enuminfo.optimized.backend.repository.AbstractRepository;
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
            return getRepository().findByColumnWithPaging(with("name", "%" + filter + "%").parameters(), start, end);
        }
	}

	@Override
	public int getDataSize(String filter) {
		if (filter.equals("")) {
            return getRepository().findAll().size();
        } else {
            return getRepository().findByColumn(with("code", "%" + filter + "%").parameters()).size();
        }
	}

	@Override
	public String getName() {
		return CountryController.class.getSimpleName();
	}

	@Override
	protected AbstractRepository<Country> createRepository() {
		return new CountryRepository();
	}

	@Override
	protected DataPageView<Country> createDataPageView() {
		return new CountryView();
	}
}
