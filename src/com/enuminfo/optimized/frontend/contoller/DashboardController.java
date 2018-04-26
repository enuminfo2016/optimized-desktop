/**
 * Optimized Java Swing Application Demo
 * Copyright(c) 2018, enuminfo.com
 */
package com.enuminfo.optimized.frontend.contoller;

import com.enuminfo.optimized.framework.AbstractPageController;
import com.enuminfo.optimized.framework.PageView;
import com.enuminfo.optimized.frontend.view.DashboardView;
import com.enuminfo.optimized.service.CustomerService;
import com.enuminfo.optimized.service.ProductService;

/**
 * Dashboard Controller
 * @author Kumar
 */
public class DashboardController extends AbstractPageController {

	public DashboardController() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getName() {
		return DashboardController.class.getSimpleName();
	}

	@Override
	protected PageView createPageView() {
		return new DashboardView();
	}

	public int getProductsCount() {
		return new ProductService().getListWithNamedQuery().size();
	}
	
	public int getCustomersCount() {
		return new CustomerService().getListWithNamedQuery().size();
	}
}
