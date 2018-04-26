/**
 * Optimized Java Swing Application Demo
 * Copyright(c) 2018, enuminfo.com
 */
package com.enuminfo.optimized.service;

import java.util.ArrayList;
import java.util.List;

import com.enuminfo.optimized.backend.entity.CategoryEntity;
import com.enuminfo.optimized.backend.repository.CategoryRepository;
import com.enuminfo.optimized.frontend.component.ComboBoxItem;
import com.enuminfo.optimized.frontend.model.Category;

/**
 * Category Service
 * @author Kumar
 */
public class CategoryService extends AbstractService<Category> {

	public CategoryService() {
		super(Category.class);
	}

	@Override
	public Object getRepository() {
		return new CategoryRepository();
	}

	@Override
	public String getNamedQuery() {
		return CategoryEntity.FIND_ALL;
	}

	@Override
	public String getNamedQueryWithFilter() {
		return CategoryEntity.FIND_BY_NAME;
	}

	@Override
	public void add(Category model) {

	}

	@Override
	public void edit(Category model) {

	}

	@Override
	public Category getById(Integer id) {
		return null;
	}

	@Override
	public List<Category> getListWithNamedQuery() {
		List<Category> categories = new ArrayList<>();
		((CategoryRepository) getRepository()).findWithNamedQuery(getNamedQuery()).forEach(entity -> {
			Category category = new Category();
			category.setId(entity.getId());
			category.setName(entity.getName());
			categories.add(category);
		});
		return categories;
	}

	@Override
	public List<Category> getListWithNamedQueryAndParameters(String filter) {
		List<Category> categories = new ArrayList<>();
		return categories;
	}

	@Override
	public List<Category> getListWithNamedQueryAndParameters(String filter, int start, int end) {
		List<Category> categories = new ArrayList<>();
		return categories;
	}

	@Override
	public List<Category> getListWithNamedQuery(int start, int end) {
		List<Category> categories = new ArrayList<>();
		return categories;
	}
	
	@Override
	public List<ComboBoxItem> getListOfReferences() {
		List<ComboBoxItem> comboBoxItems = new ArrayList<ComboBoxItem>();
		getListWithNamedQuery().forEach(model -> {
			comboBoxItems.add(new ComboBoxItem(String.valueOf(model.getId()), model.getName()));
		});
		return comboBoxItems;
	}
}
