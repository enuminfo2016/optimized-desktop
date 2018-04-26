/**
 * Optimized Java Swing Application Demo
 * Copyright(c) 2018, enuminfo.com
 */
package com.enuminfo.optimized.service;

import java.util.ArrayList;
import java.util.List;

import com.enuminfo.optimized.backend.entity.SaleOrderEntity;
import com.enuminfo.optimized.backend.repository.SaleOrderRepository;
import com.enuminfo.optimized.frontend.component.ComboBoxItem;
import com.enuminfo.optimized.frontend.model.SaleOrder;

/**
 * Sale Order Service
 * @author Kumar
 */
public class SaleOrderService extends AbstractService<SaleOrder> {

	public SaleOrderService() {
		super(SaleOrder.class);
	}

	@Override
	public Object getRepository() {
		return new SaleOrderRepository();
	}

	@Override
	public String getNamedQuery() {
		return SaleOrderEntity.FIND_ALL;
	}

	@Override
	public String getNamedQueryWithFilter() {
		return null;
	}

	@Override
	public void add(SaleOrder model) {
		
	}

	@Override
	public void edit(SaleOrder model) {
		
	}

	@Override
	public SaleOrder getById(Integer id) {
		return null;
	}

	@Override
	public List<SaleOrder> getListWithNamedQuery() {
		List<SaleOrder> saleOrders = new ArrayList<>();
		return saleOrders;
	}

	@Override
	public List<SaleOrder> getListWithNamedQueryAndParameters(String filter) {
		List<SaleOrder> saleOrders = new ArrayList<>();
		return saleOrders;
	}

	@Override
	public List<SaleOrder> getListWithNamedQueryAndParameters(String filter, int start, int end) {
		List<SaleOrder> saleOrders = new ArrayList<>();
		return saleOrders;
	}

	@Override
	public List<SaleOrder> getListWithNamedQuery(int start, int end) {
		List<SaleOrder> saleOrders = new ArrayList<>();
		return saleOrders;
	}

	@Override
	public List<ComboBoxItem> getListOfReferences() {
		return null;
	}
}
