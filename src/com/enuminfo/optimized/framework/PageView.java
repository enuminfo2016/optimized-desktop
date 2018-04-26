/*
 * Optimized Java Swing Application Demo
 * Copyright(c) 2018, enuminfo.com
 */
package com.enuminfo.optimized.framework;

/**
 * Page View interface
 * @author Kumar
 */
public interface PageView extends View {

	void init(PageController controller);
	PageController getController();
}
