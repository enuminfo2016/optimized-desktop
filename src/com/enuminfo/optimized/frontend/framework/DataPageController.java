/*
 * 
 */
package com.enuminfo.optimized.frontend.framework;

import java.util.List;

import com.enuminfo.optimized.frontend.model.Base;
import com.enuminfo.optimized.frontend.service.AbstractService;

/**
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
