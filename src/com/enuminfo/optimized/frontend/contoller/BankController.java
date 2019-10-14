/**
 * 
 */
package com.enuminfo.optimized.frontend.contoller;

import static com.enuminfo.optimized.frontend.service.QueryParameter.with;

import java.util.List;

import com.enuminfo.optimized.frontend.framework.AbstractDataPageController;
import com.enuminfo.optimized.frontend.framework.DataPageView;
import com.enuminfo.optimized.frontend.model.Bank;
import com.enuminfo.optimized.frontend.service.AbstractService;
import com.enuminfo.optimized.frontend.service.BankService;
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
            return getService().getListWithNamedQuery(with("name", "%" + filter + "%").parameters()).size();
        }
	}

	@Override
	public String getName() {
		return BankController.class.getSimpleName();
	}

	@Override
	protected AbstractService<Bank> createService() {
		return new BankService();
	}

	@Override
	protected DataPageView<Bank> createDataPageView() {
		return new BankView();
	}
}
