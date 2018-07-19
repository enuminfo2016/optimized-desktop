/**
 * 
 */
package com.enuminfo.optimized.frontend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.enuminfo.optimized.frontend.component.ComboBoxItem;
import com.enuminfo.optimized.frontend.model.SaleOrder;

/**
 * @author Kumar
 */
public class SaleOrderService extends AbstractService<SaleOrder> {

	public SaleOrderService() {
		super(SaleOrder.class);
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
	public List<SaleOrder> getListWithNamedQueryAndParameters(Map<String, Object> parameters) {
		List<SaleOrder> saleOrders = new ArrayList<>();
		return saleOrders;
	}

	@Override
	public List<SaleOrder> getListWithNamedQueryAndParameters(Map<String, Object> parameters, int start, int end) {
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
