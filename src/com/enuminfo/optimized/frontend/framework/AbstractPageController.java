/*
 * 
 */
package com.enuminfo.optimized.frontend.framework;

/**
 * @author Kumar
 */
public abstract class AbstractPageController implements PageController {

	private PageView pageView;

	protected abstract PageView createPageView();

	@Override
	public PageView getPageView() {
		if (pageView == null) {
			pageView = createPageView();
			pageView.init(this);
		}
		return pageView;
	}
}
