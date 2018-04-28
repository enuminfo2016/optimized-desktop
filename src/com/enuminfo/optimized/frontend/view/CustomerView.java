/**
 * Optimized Java Swing Application Demo
 * Copyright(c) 2018, enuminfo.com
 */
package com.enuminfo.optimized.frontend.view;

import com.enuminfo.optimized.framework.AbstractDataPageView;
import com.enuminfo.optimized.framework.AbstractPreviewPanel;
import com.enuminfo.optimized.framework.EntityTableColumn;
import com.enuminfo.optimized.frontend.I18n;
import com.enuminfo.optimized.frontend.ViewHelpers;
import com.enuminfo.optimized.frontend.model.Customer;

/**
 * Customer Page View
 * 
 * @author Kumar
 */
public class CustomerView extends AbstractDataPageView<Customer> {

	@Override
	public String getTitle() {
		return I18n.OPTIMIZED.getString("Customer.Page.Title");
	}

	@Override
	public String getIconPath() {
		return ViewHelpers.ICONS16 + "customer.png";
	}

	@Override
	public void addTableColumns() {
		getTableModel().addColumn(new EntityTableColumn(I18n.OPTIMIZED.getString("Customer.Page.CompanyName"),
				"companyName", String.class, 300));
		getTableModel().addColumn(new EntityTableColumn(I18n.OPTIMIZED.getString("Customer.Page.CompanyPhone"),
				"companyPhone", String.class, 300));
		getTableModel().addColumn(new EntityTableColumn(I18n.OPTIMIZED.getString("Customer.Page.CompanyFax"),
				"companyFax", String.class, 300));
		getTableModel().addColumn(new EntityTableColumn(I18n.OPTIMIZED.getString("Customer.Page.PersonName"),
				"personName", String.class, 300));
		getTableModel().addColumn(new EntityTableColumn(I18n.OPTIMIZED.getString("Customer.Page.PersonMobile"),
				"personMobile", String.class, 300));
		getTableModel().addColumn(new EntityTableColumn(I18n.OPTIMIZED.getString("Customer.Page.PersonEmail"),
				"personEmail", String.class, 300));
	}

	@Override
	public AbstractPreviewPanel<Customer> getPreviewPanel() {
		// return new CustomerPreview();
		return null;
	}
}
