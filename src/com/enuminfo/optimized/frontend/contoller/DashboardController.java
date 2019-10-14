/**
 * 
 */
package com.enuminfo.optimized.frontend.contoller;

import com.enuminfo.optimized.frontend.framework.AbstractPageController;
import com.enuminfo.optimized.frontend.framework.PageView;
import com.enuminfo.optimized.frontend.view.DashboardView;

/**
 * @author Kumar
 */
public class DashboardController extends AbstractPageController {

	@Override
	public String getName() {
		return DashboardController.class.getSimpleName();
	}

	@Override
	protected PageView createPageView() {
		return new DashboardView();
	}
}
