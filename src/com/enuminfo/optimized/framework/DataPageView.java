/*
 * Optimized Java Swing Application Demo
 * Copyright(c) 2018, enuminfo.com
 */
package com.enuminfo.optimized.framework;

import com.enuminfo.optimized.frontend.model.Base;

/**
 * Data Page View interface
 * @param <T> entity
 * @author Kumar
 */
public interface DataPageView<T extends Base> extends View {

	void init(DataPageController<T> controller);
	DataPageController<T> getController();
	T getSelectedModel();
	void refreshData();
}
