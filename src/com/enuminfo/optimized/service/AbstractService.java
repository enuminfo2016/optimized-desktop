/*
 * Optimized Java Swing Application Demo
 * Copyright(c) 2018, enuminfo.com
 */
package com.enuminfo.optimized.service;

import java.util.List;

import com.enuminfo.optimized.frontend.component.ComboBoxItem;
import com.enuminfo.optimized.frontend.model.Base;

/**
 * Abstract Service for all services.
 * @param <T> model
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
	public abstract List<T> getListWithNamedQueryAndParameters(String filter);
	public abstract List<T> getListWithNamedQueryAndParameters(String filter, int start, int end);
	public abstract List<T> getListWithNamedQuery(int start, int end);
	
	public abstract List<ComboBoxItem> getListOfReferences();
}
