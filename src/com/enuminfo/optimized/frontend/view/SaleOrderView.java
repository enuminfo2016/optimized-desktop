/**
 * 
 */
package com.enuminfo.optimized.frontend.view;

import com.enuminfo.optimized.frontend.I18n;
import com.enuminfo.optimized.frontend.ViewHelpers;
import com.enuminfo.optimized.frontend.framework.AbstractDataPageView;
import com.enuminfo.optimized.frontend.framework.AbstractPreviewPanel;
import com.enuminfo.optimized.frontend.framework.EntityTableColumn;
import com.enuminfo.optimized.frontend.model.SaleOrder;

/**
 * @author Kumar
 */
public class SaleOrderView extends AbstractDataPageView<SaleOrder> {

	@Override
	public String getTitle() {
		return I18n.OPTIMIZED.getString("SaleOrder.Page.Title");
	}

	@Override
	public String getIconPath() {
		return ViewHelpers.ICONS16 + "category.png";
	}

	@Override
	public void addTableColumns() {
		getTableModel().addColumn(new EntityTableColumn(I18n.OPTIMIZED.getString("SaleOrder.Page.OrderNumber"),
				"orderNumber", String.class, 300));
		getTableModel().addColumn(new EntityTableColumn(I18n.OPTIMIZED.getString("SaleOrder.Page.Customer"), "customer",
				String.class, 300));
		getTableModel().addColumn(new EntityTableColumn(I18n.OPTIMIZED.getString("SaleOrder.Page.OrderAmount"),
				"orderAmount", Double.class, 300));
	}

	@Override
	public AbstractPreviewPanel<SaleOrder> getPreviewPanel() {
		return null;
	}
}
