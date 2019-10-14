/**
 * 
 */
package com.enuminfo.optimized.frontend.view;

import com.enuminfo.optimized.frontend.I18n;
import com.enuminfo.optimized.frontend.ViewHelpers;
import com.enuminfo.optimized.frontend.framework.AbstractDataPageView;
import com.enuminfo.optimized.frontend.framework.AbstractPreviewPanel;
import com.enuminfo.optimized.frontend.framework.EntityTableColumn;
import com.enuminfo.optimized.frontend.model.Location;

/**
 * @author Kumar
 */
public class LocationView extends AbstractDataPageView<Location> {

	@Override
	public String getTitle() {
		return I18n.OPTIMIZED.getString("Location.Page.Title");
	}

	@Override
	public String getIconPath() {
		return ViewHelpers.ICONS16 + "country.png";
	}

	@Override
	public void addTableColumns() {
		getTableModel().addColumn(new EntityTableColumn(I18n.OPTIMIZED.getString("Location.Page.Name"),
				"name", String.class, 300));
		getTableModel().addColumn(new EntityTableColumn(I18n.OPTIMIZED.getString("Location.Page.Pin"),
				"pin", String.class, 100));
		getTableModel().addColumn(new EntityTableColumn(I18n.OPTIMIZED.getString("Location.Page.City"),
				"city", String.class, 300));
		getTableModel().addColumn(new EntityTableColumn(I18n.OPTIMIZED.getString("Location.Page.State"),
				"state", String.class, 300));
	}

	@Override
	public AbstractPreviewPanel<Location> getPreviewPanel() {
		return null;
	}
}
