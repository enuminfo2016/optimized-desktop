/*
 * 
 */
package com.enuminfo.optimized.frontend.framework;

import com.enuminfo.optimized.frontend.model.Base;

/**
 * @author Kumar
 */
public interface DataPageView<T extends Base> extends View {

	void init(DataPageController<T> controller);

	DataPageController<T> getController();

	T getSelectedModel();

	void refreshData();
}
