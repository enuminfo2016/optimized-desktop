/*
 * 
 */
package com.enuminfo.optimized.framework;

/**
 * @author AKURATI
 */
public interface PageView extends View {

	void init(PageController controller);

	PageController getController();
}
