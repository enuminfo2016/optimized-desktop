/**
 * Optimized Java Swing Application Demo
 * Copyright(c) 2018, enuminfo.com
 */
package com.enuminfo.optimized.service;

import java.util.ArrayList;
import java.util.List;

import com.enuminfo.optimized.backend.entity.CustomerEntity;
import com.enuminfo.optimized.backend.repository.CustomerRepository;
import com.enuminfo.optimized.frontend.component.ComboBoxItem;
import com.enuminfo.optimized.frontend.model.Customer;

/**
 * Customer Service
 * @author Kumar
 */
public class CustomerService extends AbstractService<Customer> {

	public CustomerService() {
		super(Customer.class);
	}

	@Override
	public Object getRepository() {
		return new CustomerRepository();
	}

	@Override
	public String getNamedQuery() {
		return CustomerEntity.FIND_ALL;
	}

	@Override
	public String getNamedQueryWithFilter() {
		return CustomerEntity.FIND_BY_NAME;
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
	public List<Customer> getListWithNamedQueryAndParameters(String filter) {
		List<Customer> customers = new ArrayList<>();
		return customers;
	}

	@Override
	public List<Customer> getListWithNamedQueryAndParameters(String filter, int start, int end) {
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
		return null;
	}
}
