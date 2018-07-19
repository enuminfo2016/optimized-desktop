/**
 * 
 */
package com.enuminfo.optimized.frontend.contoller;

import java.util.ArrayList;
import java.util.List;

import com.enuminfo.optimized.frontend.form.SaleOrderForm;
import com.enuminfo.optimized.frontend.framework.AbstractDataPageController;
import com.enuminfo.optimized.frontend.framework.DataPageView;
import com.enuminfo.optimized.frontend.model.SaleOrder;
import com.enuminfo.optimized.frontend.service.AbstractService;
import com.enuminfo.optimized.frontend.service.SaleOrderService;
import com.enuminfo.optimized.frontend.view.SaleOrderView;

/**
 * @author Kumar
 */
public class SaleOrderController extends AbstractDataPageController<SaleOrder> {

	@Override
	public void openFormView(SaleOrder saleOrder) {
		new SaleOrderForm(this, saleOrder).showDialog();
	}

	@Override
	public void onAddNew() {
		openFormView(new SaleOrder());
	}

	@Override
	public List<SaleOrder> getData(String filter, int start, int end) {
		if (filter.equals(""))
			return getService().getListWithNamedQuery(start, end);
		else
			return new ArrayList<>();
	}

	@Override
	public int getDataSize(String filter) {
		if (filter.equals(""))
			return getService().getListWithNamedQuery().size();
		else
			return 0;
	}

	@Override
	public String getName() {
		return SaleOrderController.class.getSimpleName();
	}

	@Override
	protected AbstractService<SaleOrder> createService() {
		return new SaleOrderService();
	}

	@Override
	protected DataPageView<SaleOrder> createDataPageView() {
		return new SaleOrderView();
	}
}
