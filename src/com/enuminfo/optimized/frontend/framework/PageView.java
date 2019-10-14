/*
 * 
 */
package com.enuminfo.optimized.frontend.framework;

/**
 * @author Kumar
 */
public interface PageView extends View {

	void init(PageController controller);

	PageController getController();
}
