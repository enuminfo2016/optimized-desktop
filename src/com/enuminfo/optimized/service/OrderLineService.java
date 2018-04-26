/**
 * Optimized Java Swing Application Demo
 * Copyright(c) 2018, enuminfo.com
 */
package com.enuminfo.optimized.service;

import java.util.ArrayList;
import java.util.List;

import com.enuminfo.optimized.backend.entity.OrderLineEntity;
import com.enuminfo.optimized.backend.repository.OrderLineRepository;
import com.enuminfo.optimized.frontend.component.ComboBoxItem;
import com.enuminfo.optimized.frontend.model.OrderLine;

/**
 * Order Line Service
 * @author Kumar
 */
public class OrderLineService extends AbstractService<OrderLine> {

	public OrderLineService() {
		super(OrderLine.class);
	}

	@Override
	public Object getRepository() {
		return new OrderLineRepository();
	}

	@Override
	public String getNamedQuery() {
		return OrderLineEntity.FIND_ALL;
	}

	@Override
	public String getNamedQueryWithFilter() {
		return null;
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
	public List<OrderLine> getListWithNamedQueryAndParameters(String filter) {
		return null;
	}

	@Override
	public List<OrderLine> getListWithNamedQueryAndParameters(String filter, int start, int end) {
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
