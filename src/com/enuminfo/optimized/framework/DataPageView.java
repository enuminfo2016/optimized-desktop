/*
 * 
 */
package com.enuminfo.optimized.framework;

import com.enuminfo.optimized.backend.model.Base;

/**
 * @author AKURATI
 */
public interface DataPageView<T extends Base> extends View {

	void init(DataPageController<T> controller);

	DataPageController<T> getController();

	T getSelectedModel();

	void refreshData();
}
