/*
 * 
 */
package com.enuminfo.optimized.frontend.service;

import java.util.List;
import java.util.Map;

import com.enuminfo.optimized.frontend.component.ComboBoxItem;
import com.enuminfo.optimized.frontend.model.Base;

/**
 * @author Kumar
 */
public abstract class AbstractService<T extends Base> {

	private final Class<T> modelClass;

	public AbstractService(Class<T> modelClass) {
		this.modelClass = modelClass;
	}

	public Class<T> getModelClass() {
		return modelClass;
	}

	public abstract Object getRepository();

	public abstract String getNamedQuery();

	public abstract String getNamedQueryWithFilter();

	public abstract void add(T model);

	public abstract void edit(T model);

	public abstract T getById(Integer id);

	public abstract List<T> getListWithNamedQuery();

	public abstract List<T> getListWithNamedQueryAndParameters(Map<String, Object> parameters);

	public abstract List<T> getListWithNamedQueryAndParameters(Map<String, Object> parameters, int start, int end);

	public abstract List<T> getListWithNamedQuery(int start, int end);

	public abstract List<ComboBoxItem> getListOfReferences();
}
