/**
 * Optimized Java Swing Application Demo
 * Copyright(c) 2018, enuminfo.com
 */
package com.enuminfo.optimized.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.enuminfo.optimized.backend.entity.OrderLineEntity;
import com.enuminfo.optimized.backend.entity.ProductEntity;
import com.enuminfo.optimized.backend.entity.SaleOrderEntity;
import com.enuminfo.optimized.backend.repository.CustomerRepository;
import com.enuminfo.optimized.backend.repository.ProductRepository;
import com.enuminfo.optimized.backend.repository.SaleOrderRepository;
import com.enuminfo.optimized.frontend.component.ComboBoxItem;
import com.enuminfo.optimized.frontend.model.SaleOrder;

/**
 * Sale Order Service
 * 
 * @author Kumar
 */
public class SaleOrderService extends AbstractService<SaleOrder> {

	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("EEEE', 'dd MMMM yyyy");

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
		SaleOrderEntity entity = new SaleOrderEntity();
		try {
			entity.setOrderNumber(model.getOrderNumber());
			entity.setOrderDate(DATE_FORMAT.parse(model.getOrderDate()));
			entity.setCustomer(((CustomerRepository) getRepository()).find(Integer.parseInt(model.getCId())));
			Collection<OrderLineEntity> lineEntities = new ArrayList<>();
			model.getOrderLines().forEach(item -> {
				OrderLineEntity lineEntity = new OrderLineEntity();
				((ProductRepository) getRepository()).findWithNamedQuery(ProductEntity.FIND_ALL).forEach(product -> {
					if (product.getName().equals(item.getProduct()))
						lineEntity.setProduct(product);
				});
				lineEntity.setQuantity(item.getQuantity());
				lineEntity.setUnitPrice(item.getUnitPrice());
				lineEntities.add(lineEntity);
			});
			entity.setOrderLines(lineEntities);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		((SaleOrderRepository) getRepository()).save(entity);
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
