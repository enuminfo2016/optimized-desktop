/**
 * 
 */
package com.enuminfo.optimized.frontend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.enuminfo.optimized.frontend.component.ComboBoxItem;
import com.enuminfo.optimized.frontend.model.Category;

/**
 * @author Kumar
 */
public class CategoryService extends AbstractService<Category> {

	public CategoryService() {
		super(Category.class);
	}

	@Override
	public void add(Category model) {

	}

	@Override
	public void edit(Category model) {

	}

	@Override
	public Category getById(Integer id) {
		Category category = new Category();
		return category;
	}

	@Override
	public List<Category> getListWithNamedQuery() {
		List<Category> categories = new ArrayList<>();
		return categories;
	}

	@Override
	public List<Category> getListWithNamedQueryAndParameters(Map<String, Object> parameters) {
		List<Category> categories = new ArrayList<>();
		return categories;
	}

	@Override
	public List<Category> getListWithNamedQueryAndParameters(Map<String, Object> parameters, int start, int end) {
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
