/**
 * Optimized Java Swing Application Demo
 * Copyright(c) 2018, enuminfo.com
 */
package com.enuminfo.optimized.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.enuminfo.optimized.backend.entity.ProductEntity;
import com.enuminfo.optimized.backend.repository.CategoryRepository;
import com.enuminfo.optimized.backend.repository.ProductRepository;
import com.enuminfo.optimized.frontend.component.ComboBoxItem;
import com.enuminfo.optimized.frontend.model.Product;

/**
 * Product Service
 * 
 * @author Kumar
 */
public class ProductService extends AbstractService<Product> {

	public ProductService() {
		super(Product.class);
	}

	@Override
	public Object getRepository() {
		return new ProductRepository();
	}

	@Override
	public void add(Product model) {
		ProductEntity entity = new ProductEntity();
		entity.setName(model.getName());
		entity.setCategory(new CategoryRepository().find(model.getCId()));
		((ProductRepository) getRepository()).save(entity);
	}

	@Override
	public void edit(Product model) {
		ProductEntity entity = new ProductEntity();
		entity.setId(model.getId());
		entity.setName(model.getName());
		entity.setCategory(new CategoryRepository().find(model.getCId()));
		((ProductRepository) getRepository()).saveOrUpdate(entity);
	}

	@Override
	public Product getById(Integer id) {
		return null;
	}

	@Override
	public String getNamedQuery() {
		return ProductEntity.FIND_ALL;
	}

	@Override
	public String getNamedQueryWithFilter() {
		return ProductEntity.FIND_BY_CODE;
	}

	@Override
	public List<Product> getListWithNamedQuery() {
		List<Product> products = new ArrayList<>();
		((ProductRepository) getRepository()).findWithNamedQuery(getNamedQuery()).forEach(entity -> {
			Product product = new Product();
			product.setId(entity.getId());
			product.setName(entity.getName());
			product.setCode(entity.getCode());
			product.setCId(entity.getCategory().getId());
			product.setCategory(entity.getCategory().getName());
			products.add(product);
		});
		return products;
	}

	@Override
	public List<Product> getListWithNamedQueryAndParameters(Map<String, Object> parameters) {
		List<Product> products = new ArrayList<>();
		((ProductRepository) getRepository()).findWithNamedQuery(getNamedQueryWithFilter(), parameters)
				.forEach(entity -> {
					Product product = new Product();
					product.setId(entity.getId());
					product.setName(entity.getName());
					product.setCode(entity.getCode());
					product.setCId(entity.getCategory().getId());
					product.setCategory(entity.getCategory().getName());
					products.add(product);
				});
		return products;
	}

	@Override
	public List<Product> getListWithNamedQueryAndParameters(Map<String, Object> parameters, int start, int end) {
		List<Product> products = new ArrayList<>();
		((ProductRepository) getRepository()).findWithNamedQuery(getNamedQueryWithFilter(), parameters, start, end)
				.forEach(entity -> {
					Product product = new Product();
					product.setId(entity.getId());
					product.setName(entity.getName());
					product.setCode(entity.getCode());
					product.setCId(entity.getCategory().getId());
					product.setCategory(entity.getCategory().getName());
					products.add(product);
				});
		return products;
	}

	@Override
	public List<Product> getListWithNamedQuery(int start, int end) {
		List<Product> products = new ArrayList<>();
		((ProductRepository) getRepository()).findWithNamedQuery(getNamedQuery(), start, end).forEach(entity -> {
			Product product = new Product();
			product.setId(entity.getId());
			product.setName(entity.getName());
			product.setCode(entity.getCode());
			product.setCId(entity.getCategory().getId());
			product.setCategory(entity.getCategory().getName());
			products.add(product);
		});
		return products;
	}

	@Override
	public List<ComboBoxItem> getListOfReferences() {
		return null;
	}
}
