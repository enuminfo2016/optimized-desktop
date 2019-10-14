/**
 * 
 */
package com.enuminfo.optimized.frontend.view;

import com.enuminfo.optimized.frontend.I18n;
import com.enuminfo.optimized.frontend.ViewHelpers;
import com.enuminfo.optimized.frontend.framework.AbstractDataPageView;
import com.enuminfo.optimized.frontend.framework.AbstractPreviewPanel;
import com.enuminfo.optimized.frontend.framework.EntityTableColumn;
import com.enuminfo.optimized.frontend.model.Bank;

/**
 * @author Kumar
 */
public class BankView extends AbstractDataPageView<Bank> {

	@Override
	public String getTitle() {
		return I18n.OPTIMIZED.getString("Bank.Page.Title");
	}

	@Override
	public String getIconPath() {
		return ViewHelpers.ICONS16 + "category.png";
	}

	@Override
	public void addTableColumns() {
		getTableModel().addColumn(new EntityTableColumn(I18n.OPTIMIZED.getString("Bank.Page.Name"),
				"name", String.class, 300));
		getTableModel().addColumn(new EntityTableColumn(I18n.OPTIMIZED.getString("Bank.Page.Ifsc"),
				"ifsc", String.class, 100));
		getTableModel().addColumn(new EntityTableColumn(I18n.OPTIMIZED.getString("Bank.Page.Micr"),
				"micr", String.class, 100));
		getTableModel().addColumn(new EntityTableColumn(I18n.OPTIMIZED.getString("Bank.Page.Branch"),
				"branch", String.class, 300));
		getTableModel().addColumn(new EntityTableColumn(I18n.OPTIMIZED.getString("Bank.Page.Address"),
				"branch", String.class, 300));
		getTableModel().addColumn(new EntityTableColumn(I18n.OPTIMIZED.getString("Bank.Page.Contact"),
				"branch", String.class, 200));
	}

	@Override
	public AbstractPreviewPanel<Bank> getPreviewPanel() {
		return null;
	}
}
