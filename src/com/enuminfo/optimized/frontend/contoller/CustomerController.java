/**
 * Optimized Java Swing Application Demo
 * Copyright(c) 2018, enuminfo.com
 */
package com.enuminfo.optimized.frontend.contoller;

import java.util.List;

import com.enuminfo.optimized.framework.AbstractDataPageController;
import com.enuminfo.optimized.framework.DataPageView;
import com.enuminfo.optimized.frontend.form.CustomerForm;
import com.enuminfo.optimized.frontend.model.Customer;
import com.enuminfo.optimized.frontend.view.CustomerView;
import com.enuminfo.optimized.service.AbstractService;
import com.enuminfo.optimized.service.CustomerService;

/**
 * Customer Controller
 * @author Kumar
 */
public class CustomerController extends AbstractDataPageController<Customer> {

	@Override
	public void openFormView(Customer customer) {
		new CustomerForm(this, customer).showDialog();
	}

	@Override
	public void onAddNew() {
		openFormView(new Customer());
	}

	@Override
	public List<Customer> getData(String filter, int start, int end) {
		if (filter.equals(""))
			return getService().getListWithNamedQuery(start, end);
		else
			return getService().getListWithNamedQueryAndParameters(filter, start, end);
	}

	@Override
	public int getDataSize(String filter) {
		if (filter.equals(""))
			return getService().getListWithNamedQuery().size();
		else
			return getService().getListWithNamedQueryAndParameters(filter).size();
	}

	@Override
	public String getName() {
		return CustomerController.class.getSimpleName();
	}

	@Override
	protected AbstractService<Customer> createService() {
		return new CustomerService();
	}

	@Override
	protected DataPageView<Customer> createDataPageView() {
		return new CustomerView();
	}
}
