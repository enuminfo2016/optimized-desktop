/**
 * 
 */
package com.enuminfo.optimized.frontend.view;

import com.enuminfo.optimized.backend.model.Country;
import com.enuminfo.optimized.framework.AbstractDataPageView;
import com.enuminfo.optimized.framework.AbstractPreviewPanel;
import com.enuminfo.optimized.framework.EntityTableColumn;
import com.enuminfo.optimized.uitl.I18n;
import com.enuminfo.optimized.uitl.ViewHelpers;

/**
 * @author AKURATI
 */
public class CountryView extends AbstractDataPageView<Country> {

	@Override
	public String getTitle() {
		return I18n.OPTIMIZED.getString("Country.Page.Title");
	}

	@Override
	public String getIconPath() {
		return ViewHelpers.ICONS16 + "country.png";
	}

	@Override
	public void addTableColumns() {
		getTableModel().addColumn(new EntityTableColumn(I18n.OPTIMIZED.getString("Country.Page.Name"),
				"name", String.class, 400));
		getTableModel().addColumn(new EntityTableColumn(I18n.OPTIMIZED.getString("Country.Page.Isd"),
				"isd", String.class, 400));
	}

	@Override
	public AbstractPreviewPanel<Country> getPreviewPanel() {
		return null;
	}
}
