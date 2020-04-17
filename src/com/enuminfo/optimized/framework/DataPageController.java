/*
 * 
 */
package com.enuminfo.optimized.framework;

import java.util.List;

import com.enuminfo.optimized.backend.model.Base;
import com.enuminfo.optimized.backend.repository.BaseRepository;

/**
 * @author AKURATI
 */
public interface DataPageController<T extends Base> extends Controller {

	BaseRepository<T> getRepository();

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
