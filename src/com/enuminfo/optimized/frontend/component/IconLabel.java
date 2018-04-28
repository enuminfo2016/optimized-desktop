/*
 * Optimized Java Swing Application Demo
 * Copyright(c) 2018, enuminfo.com
 */
package com.enuminfo.optimized.frontend.component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Icon Label component.
 * 
 * @author Kumar
 */
public class IconLabel extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IconLabel(ImageIcon icon) {
		this(icon, "", JLabel.CENTER, JLabel.RIGHT);
	}

	public IconLabel(ImageIcon icon, int verticalTextPos, int horizontalTextPos) {
		this(icon, "", verticalTextPos, horizontalTextPos);
	}

	public IconLabel(ImageIcon icon, String text, int verticalTextPos, int horizontalTextPos) {
		super(text, icon, SwingConstants.CENTER);
		setVerticalTextPosition(verticalTextPos);
		setHorizontalTextPosition(horizontalTextPos);
		setIconTextGap(10);
	}
}
