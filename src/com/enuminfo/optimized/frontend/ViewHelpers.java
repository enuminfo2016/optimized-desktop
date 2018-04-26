/*
 * Optimized Java Swing Application Demo
 * Copyright(c) 2018, enuminfo.com
 */
package com.enuminfo.optimized.frontend;

import java.awt.Component;
import javax.swing.*;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.io.IOException;
import java.net.URI;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.MaskFormatter;
import org.jdesktop.swingx.JXTitledSeparator;
import org.jvnet.flamingo.common.icon.ResizableIcon;
import org.jvnet.substance.api.ColorSchemeAssociationKind;
import org.jvnet.substance.api.ComponentState;
import org.jvnet.substance.api.SubstanceColorScheme;
import org.jvnet.substance.utils.SubstanceColorSchemeUtilities;

import com.enuminfo.optimized.frontend.component.MessageBox;

/**
 * View Helpers
 * @author Kumar
 */
public class ViewHelpers {

	private final static Logger LOGGER = Logger.getLogger(ViewHelpers.class.getName());

	public static final String ICONS12 = "/com/enuminfo/optimized/resources/icons12/";
	public static final String ICONS16 = "/com/enuminfo/optimized/resources/icons16/";
	public static final String ICONS22 = "/com/enuminfo/optimized/resources/icons22/";
	public static final String IMAGES = "/com/enuminfo/optimized/resources/images/";
	
	public ViewHelpers() {
		// TODO Auto-generated constructor stub
	}

	public static AbstractButton createToolButton(Action action) {
		return createToolButton(action, false, false);
	}

	public static AbstractButton createToolButton(Action action, boolean showTitle) {
		return createToolButton(action, showTitle, false);
	}

	public static AbstractButton createToolButton(Action action, boolean showTitle, boolean titlePositionBottom) {
		AbstractButton btn = new JButton(action);
		btn.setFocusPainted(false);
		btn.setMargin(new Insets(0, 0, 0, 0));

		if (!showTitle) {
			btn.setText("");
		}

		if (titlePositionBottom) {
			btn.setHorizontalTextPosition(SwingConstants.CENTER);
			btn.setVerticalTextPosition(SwingConstants.BOTTOM);
		}

		if (btn.getPreferredSize().width < 50) {
			btn.setMaximumSize(new Dimension(50, 41));
			btn.setMaximumSize(new Dimension(50, 41));
		}

		return btn;
	}

	public static JXTitledSeparator createBoldTitledSeperator(String title) {
		return new JXTitledSeparator("<html><body><b>" + title + "</b></body></html>");
	}

	public static Color getSubstanceComponentBorderColor(Component component) {
		SubstanceColorScheme borderColorScheme = SubstanceColorSchemeUtilities.getColorScheme(component,
				ColorSchemeAssociationKind.BORDER, ComponentState.DEFAULT);
		return borderColorScheme.getDarkColor();
	}

	public static ResizableIcon createResizableIcon(final Icon icon) {
		ResizableIcon resizableIcon = new ResizableIcon() {
			int width = icon.getIconWidth();
			int height = icon.getIconHeight();

			@Override
			public int getIconHeight() {
				return this.height;
			}

			@Override
			public int getIconWidth() {
				return this.width;
			}

			@Override
			public void paintIcon(Component c, Graphics g, int x, int y) {
				icon.paintIcon(c, g, x, y);
			}

			@Override
			public void setDimension(Dimension newDimension) {
				this.width = newDimension.width;
				this.height = newDimension.height;
			}
		};
		return resizableIcon;
	}

	public static JFormattedTextField createFormatterField(String mask) {
		MaskFormatter maskFormatter = null;
		try {
			maskFormatter = new MaskFormatter(mask);
			maskFormatter.setAllowsInvalid(true);
		} catch (ParseException ex) {
			MessageBox.showError("Mask Formatter is bad", ex);
		}

		JFormattedTextField ftfFormatterField = new JFormattedTextField(maskFormatter);
		ftfFormatterField.setValue("");
		return ftfFormatterField;
	}

	public static void browseUrl(String url) {
		try {
			Desktop.getDesktop().browse(URI.create(url));
		} catch (IOException ex) {
			LOGGER.log(Level.SEVERE, "Desktop Url browse action error", ex);
		}
	}
}
