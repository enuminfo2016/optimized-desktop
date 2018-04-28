/**
 * Optimized Java Swing Application Demo
 * Copyright(c) 2018, enuminfo.com
 */
package com.enuminfo.optimized.frontend.preview;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.enuminfo.optimized.framework.AbstractPreviewPanel;
import com.enuminfo.optimized.frontend.ViewHelpers;
import com.enuminfo.optimized.frontend.component.IconLabel;
import com.enuminfo.optimized.frontend.model.Product;

import net.miginfocom.swing.MigLayout;

/**
 * Product Preview
 * 
 * @author Kumar
 */
public class ProductPreview extends AbstractPreviewPanel<Product> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Product product;

	private IconLabel lblName;
	private IconLabel lblCode;
	private IconLabel lblCategory;

	public ProductPreview() {
		super();
	}

	@Override
	public void buildUI() {
		lblName = new IconLabel(new ImageIcon(getClass().getResource(ViewHelpers.ICONS16 + "homepage.png")));
		lblCode = new IconLabel(new ImageIcon(getClass().getResource(ViewHelpers.ICONS16 + "homepage.png")));
		lblCategory = new IconLabel(new ImageIcon(getClass().getResource(ViewHelpers.ICONS16 + "category.png")));
		JPanel panel = new JPanel(new MigLayout("insets 10 20 10 20"));
		panel.add(lblName, "wrap");
		panel.add(lblCode, "wrap");
		panel.add(lblCategory, "wrap");
		addCenterComponent(panel);
	}

	@Override
	public void popFields() {
		product = getModel();
		lblName.setText(product.getName());
		lblCode.setText(product.getCode());
		lblCategory.setText(product.getCategory());
	}
}
