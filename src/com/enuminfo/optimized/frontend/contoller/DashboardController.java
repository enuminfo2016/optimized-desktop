/**
 * 
 */
package com.enuminfo.optimized.frontend.contoller;

import com.enuminfo.optimized.framework.AbstractPageController;
import com.enuminfo.optimized.framework.PageView;
import com.enuminfo.optimized.frontend.view.DashboardView;

/**
 * @author AKURATI
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
