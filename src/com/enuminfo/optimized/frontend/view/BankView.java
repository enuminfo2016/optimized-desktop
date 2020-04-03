/**
 * 
 */
package com.enuminfo.optimized.frontend.view;

import com.enuminfo.optimized.backend.model.Bank;
import com.enuminfo.optimized.framework.AbstractDataPageView;
import com.enuminfo.optimized.framework.AbstractPreviewPanel;
import com.enuminfo.optimized.framework.EntityTableColumn;
import com.enuminfo.optimized.uitl.I18n;
import com.enuminfo.optimized.uitl.ViewHelpers;

/**
 * @author AKURATI
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
				"branch", String.class, 100));
		getTableModel().addColumn(new EntityTableColumn(I18n.OPTIMIZED.getString("Bank.Page.Contact"),
				"contact", String.class, 100));
		getTableModel().addColumn(new EntityTableColumn(I18n.OPTIMIZED.getString("Bank.Page.Address"),
				"address", String.class, 500));
	}

	@Override
	public AbstractPreviewPanel<Bank> getPreviewPanel() {
		return null;
	}
}
