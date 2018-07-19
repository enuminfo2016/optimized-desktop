/**
 * 
 */
package com.enuminfo.optimized.frontend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.enuminfo.optimized.frontend.component.ComboBoxItem;
import com.enuminfo.optimized.frontend.model.OrderLine;

/**
 * @author Kumar
 */
public class OrderLineService extends AbstractService<OrderLine> {

	public OrderLineService() {
		super(OrderLine.class);
	}

	@Override
	public void add(OrderLine model) {

	}

	@Override
	public void edit(OrderLine model) {

	}

	@Override
	public OrderLine getById(Integer id) {
		return null;
	}

	@Override
	public List<OrderLine> getListWithNamedQuery() {
		List<OrderLine> orderLines = new ArrayList<>();
		return orderLines;
	}

	@Override
	public List<OrderLine> getListWithNamedQueryAndParameters(Map<String, Object> parameters) {
		return null;
	}

	@Override
	public List<OrderLine> getListWithNamedQueryAndParameters(Map<String, Object> parameters, int start, int end) {
		return null;
	}

	@Override
	public List<OrderLine> getListWithNamedQuery(int start, int end) {
		return null;
	}

	@Override
	public List<ComboBoxItem> getListOfReferences() {
		return null;
	}
}
