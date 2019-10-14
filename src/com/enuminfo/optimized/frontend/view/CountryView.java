/**
 * 
 */
package com.enuminfo.optimized.frontend.view;

import com.enuminfo.optimized.frontend.I18n;
import com.enuminfo.optimized.frontend.ViewHelpers;
import com.enuminfo.optimized.frontend.framework.AbstractDataPageView;
import com.enuminfo.optimized.frontend.framework.AbstractPreviewPanel;
import com.enuminfo.optimized.frontend.framework.EntityTableColumn;
import com.enuminfo.optimized.frontend.model.Country;

/**
 * @author Kumar
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
