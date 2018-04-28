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
import com.enuminfo.optimized.frontend.model.Product;

/**
 * Product Page View
 * 
 * @author Kumar
 */
public class ProductView extends AbstractDataPageView<Product> {

	@Override
	public String getTitle() {
		return I18n.OPTIMIZED.getString("Product.Page.Title");
	}

	@Override
	public String getIconPath() {
		return ViewHelpers.ICONS16 + "category.png";
	}

	@Override
	public void addTableColumns() {
		getTableModel().addColumn(
				new EntityTableColumn(I18n.OPTIMIZED.getString("Product.Page.Name"), "name", String.class, 300));
		getTableModel().addColumn(
				new EntityTableColumn(I18n.OPTIMIZED.getString("Product.Page.Code"), "code", String.class, 300));
	}

	@Override
	public AbstractPreviewPanel<Product> getPreviewPanel() {
		// return new ProductPreview();
		return null;
	}
}
