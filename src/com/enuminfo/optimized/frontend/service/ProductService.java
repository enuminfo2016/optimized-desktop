/**
 * 
 */
package com.enuminfo.optimized.frontend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.enuminfo.optimized.frontend.component.ComboBoxItem;
import com.enuminfo.optimized.frontend.model.Product;

/**
 * @author Kumar
 */
public class ProductService extends AbstractService<Product> {

	public ProductService() {
		super(Product.class);
	}

	@Override
	public void add(Product model) {
		
	}

	@Override
	public void edit(Product model) {
		
	}

	@Override
	public Product getById(Integer id) {
		return null;
	}

	@Override
	public List<Product> getListWithNamedQuery() {
		List<Product> products = new ArrayList<>();
		return products;
	}

	@Override
	public List<Product> getListWithNamedQueryAndParameters(Map<String, Object> parameters) {
		List<Product> products = new ArrayList<>();
		return products;
	}

	@Override
	public List<Product> getListWithNamedQueryAndParameters(Map<String, Object> parameters, int start, int end) {
		List<Product> products = new ArrayList<>();
		return products;
	}

	@Override
	public List<Product> getListWithNamedQuery(int start, int end) {
		List<Product> products = new ArrayList<>();
		return products;
	}

	@Override
	public List<ComboBoxItem> getListOfReferences() {
		return null;
	}
}
