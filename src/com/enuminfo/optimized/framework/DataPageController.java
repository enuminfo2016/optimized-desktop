/*
 * Optimized Java Swing Application Demo
 * Copyright(c) 2018, enuminfo.com
 */
package com.enuminfo.optimized.framework;

import java.util.List;

import com.enuminfo.optimized.frontend.model.Base;
import com.enuminfo.optimized.service.AbstractService;

/**
 * Data Page Controller interface.
 * 
 * @param <T>
 *            entity
 * @author Kumar
 */
public interface DataPageController<T extends Base> extends Controller {

	AbstractService<T> getService();

	DataPageView<T> getDataPageView();

	void openFormView(T model);

	void onAddNew();

	void onEdit();

	void onDelete();

	void onRefresh();

	void onSave(T model);

	List<T> getData(String filter, int start, int end);

	int getDataSize(String filter);
}
