/**
 * 
 */
package com.enuminfo.optimized.frontend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.enuminfo.optimized.frontend.component.ComboBoxItem;
import com.enuminfo.optimized.frontend.model.Customer;

/**
 * @author Kumar
 */
public class CustomerService extends AbstractService<Customer> {

	public CustomerService() {
		super(Customer.class);
	}

	@Override
	public void add(Customer model) {

	}

	@Override
	public void edit(Customer model) {

	}

	@Override
	public Customer getById(Integer id) {
		return null;
	}

	@Override
	public List<Customer> getListWithNamedQuery() {
		List<Customer> customers = new ArrayList<>();
		return customers;
	}

	@Override
	public List<Customer> getListWithNamedQueryAndParameters(Map<String, Object> parameters) {
		List<Customer> customers = new ArrayList<>();
		return customers;
	}

	@Override
	public List<Customer> getListWithNamedQueryAndParameters(Map<String, Object> parameters, int start, int end) {
		List<Customer> customers = new ArrayList<>();
		return customers;
	}

	@Override
	public List<Customer> getListWithNamedQuery(int start, int end) {
		List<Customer> customers = new ArrayList<>();
		return customers;
	}

	@Override
	public List<ComboBoxItem> getListOfReferences() {
		List<ComboBoxItem> comboBoxItems = new ArrayList<ComboBoxItem>();
		getListWithNamedQuery().forEach(model -> {
			comboBoxItems.add(new ComboBoxItem(String.valueOf(model.getId()), model.getCompanyName()));
		});
		return comboBoxItems;
	}
}
