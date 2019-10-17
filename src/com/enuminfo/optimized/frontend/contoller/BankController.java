/**
 * 
 */
package com.enuminfo.optimized.frontend.contoller;

import static com.enuminfo.optimized.backend.repository.QueryParameter.with;

import java.util.List;

import com.enuminfo.optimized.backend.model.Bank;
import com.enuminfo.optimized.backend.repository.AbstractRepository;
import com.enuminfo.optimized.backend.repository.BankRepository;
import com.enuminfo.optimized.framework.AbstractDataPageController;
import com.enuminfo.optimized.framework.DataPageView;
import com.enuminfo.optimized.frontend.view.BankView;

/**
 * @author AKURATI
 */
public class BankController extends AbstractDataPageController<Bank> {
	
	@Override
	public void openFormView(Bank model) {
		
	}

	@Override
	public void onAddNew() {
		
	}

	@Override
	public List<Bank> getData(String filter, int start, int end) {
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
            return getRepository().findByColumn(with("name", "%" + filter + "%").parameters()).size();
        }
	}

	@Override
	public String getName() {
		return BankController.class.getSimpleName();
	}

	@Override
	protected AbstractRepository<Bank> createRepository() {
		return new BankRepository();
	}

	@Override
	protected DataPageView<Bank> createDataPageView() {
		return new BankView();
	}
}
