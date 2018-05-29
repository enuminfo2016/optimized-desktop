/*
 * Optimized Java Swing Application Demo
 * Copyright(c) 2018, enuminfo.com
 */
package com.enuminfo.optimized.frontend;

import java.awt.Component;

import javax.swing.*;

import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Window;
import java.io.IOException;
import java.net.URI;
import java.text.ParseException;
import java.util.Hashtable;
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
 * 
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
	
	protected static int cascadeOriginX = -1;
	protected static int cascadeOriginY = -1;
	
	protected static double snailAngle = Math.PI/2.0;
	protected static double snailAngleOffset = 0.0;
	protected static double snailLength = 3.0/4.0;
	protected static int snailDummy = 0;
	
	protected static int cascadeStep = 30;
	
	public static void centerOnTop(Window win) {
		center(win);
		int posX = win.getLocation().x;
		int posY = 0;
		win.setLocation(posX, posY);
		if (cascadeOriginX <= 0)
			cascadeOriginX = posX;
		if (cascadeOriginY <= 0)
			cascadeOriginY = posY;
	}

	public static void center(Window win) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = win.getSize();
		int screenWidth = screenSize.width;
		if (screenWidth > 2000)
			screenWidth = screenWidth / 2;
		if (frameSize.height > screenSize.height)
			frameSize.height = screenSize.height;
		if (frameSize.width > screenWidth)
			frameSize.width = screenWidth;
		int posX = (screenWidth - frameSize.width) / 2;
		int posY = (screenSize.height - frameSize.height) / 2;
		win.setLocation(posX, posY);
		if (cascadeOriginX <= 0)
			cascadeOriginX = posX;
		if (cascadeOriginY <= 0)
			cascadeOriginY = posY;
	}

	public static void centerOnDown(Window win) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = win.getSize();
		int screenWidth = screenSize.width;
		if (screenWidth > 2000)
			screenWidth = screenWidth / 2;
		if (frameSize.height > screenSize.height)
			frameSize.height = screenSize.height;
		if (frameSize.width > screenWidth)
			frameSize.width = screenWidth;
		int posX = (screenWidth - frameSize.width) / 2;
		int posY = screenSize.height - frameSize.height;
		win.setLocation(posX, posY);
		if (cascadeOriginX <= 0)
			cascadeOriginX = posX;
		if (cascadeOriginY <= 0)
			cascadeOriginY = posY;
	}

	public static void centerRight(Window win) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = win.getSize();
		int screenWidth = screenSize.width;
		if (screenWidth > 2000)
			screenWidth = screenWidth / 2;
		if (frameSize.height > screenSize.height)
			frameSize.height = screenSize.height;
		if (frameSize.width > screenWidth)
			frameSize.width = screenWidth;
		int posX = (screenWidth - frameSize.width);
		int posY = (screenSize.height - frameSize.height) / 2;
		win.setLocation(posX, posY);

		if (cascadeOriginX <= 0)
			cascadeOriginX = posX;
		if (cascadeOriginY <= 0)
			cascadeOriginY = posY;
	}

	public static void centerLeft(Window win) {
		center(win);
		int posX = 0;
		int posY = win.getLocation().y;
		win.setLocation(posX, posY);
		if (cascadeOriginX <= 0)
			cascadeOriginX = posX;
		if (cascadeOriginY <= 0)
			cascadeOriginY = posY;
	}

	public static void centerInParent(Window win, Window parent) {
		if (parent == null)
			return;
		Dimension d = parent.getSize();
		Point p = parent.getLocation();
		win.validate();
		Dimension dm = win.getSize();
		int x = (int) (p.getX() + d.getWidth() / 2 - dm.getWidth() / 2);
		int y = (int) (p.getY() + d.getHeight() / 2 - dm.getHeight() / 2);
		x = (x >= 0) ? x : 0;
		y = (y >= 0) ? y : 0;
		win.setLocation(x, y);
	}

	public static void centerBelow(Window win, Window parent) {
		if (parent == null) {
			return;
		}
		int x = parent.getX() + (parent.getWidth() / 2) - (win.getWidth() / 2);
		int y = parent.getY() + parent.getHeight() + 40;
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		if (x + win.getWidth() > screenDimension.width) {
			x = screenDimension.width - win.getWidth();
		}
		if (y + win.getHeight() > screenDimension.height) {
			y = screenDimension.height - win.getHeight();
		}
		win.setLocation(x, y);
	}

	public static void resetCascadeOrigin(int originX, int originY) {
		cascadeOriginX = originX;
		cascadeOriginY = originY;
	}

	public static void resetCascadeOrigin() {
		cascadeOriginX = -1;
		cascadeOriginY = -1;
	}

	public static void resetCascadeStep(int step) {
		cascadeStep = step;
	}

	public static void setCascadeLocation(Window win) {
		int posX = 0, posY = 0;
		if (cascadeOriginX <= 0 && cascadeOriginY <= 0) {
			center(win);
		} else {
			if (cascadeOriginX > 0)
				posX = cascadeOriginX;
			if (cascadeOriginY > 0)
				posY = cascadeOriginY;
			Dimension frameSize = win.getSize();
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			screenSize.width = Math.min(screenSize.width, 1280);
			if (posX <= 0 || posX + frameSize.width > screenSize.width)
				posX = 0;
			if (posY <= 0 || posY + frameSize.height > screenSize.height)
				posY = 0;
			win.setLocation(posX, posY);
			cascadeOriginX = posX + cascadeStep;
			cascadeOriginY = posY + cascadeStep;
		}
	}

	public static void setSnailLocation(Window win) {
		if (snailDummy >= 32)
			snailDummy = 0;
		switch (snailDummy) {
		case 0:
			snailAngle = -Math.PI / 2.0;
			snailAngleOffset = 0.0;
			snailLength = 0.6;
			break;
		case 8:
			snailAngle = -Math.PI / 2.0;
			snailAngleOffset = Math.PI / 8.0;
			snailLength = 0.4;
			break;
		case 16:
			snailAngle = -Math.PI / 2.0;
			snailAngleOffset = Math.PI / 8.0;
			snailLength = 0.6;
			break;
		case 24:
			snailAngle = -Math.PI / 2.0;
			snailAngleOffset = 0.0;
			snailLength = 0.4;
			break;
		}
		Dimension frameSize = win.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenSize.width = Math.min(screenSize.width, 1280);
		int x = (int) ((screenSize.width / 2.0) * snailLength * Math
				.cos(snailAngleOffset + snailAngle));
		int y = (int) ((screenSize.height / 2.0) * snailLength * Math
				.sin(snailAngleOffset + snailAngle));
		int posX = (screenSize.width - frameSize.width) / 2 + x;
		int posY = (screenSize.height - frameSize.height) / 2 + y;

		if (posX <= 0)
			posX = 0;
		else if (posX + frameSize.width > screenSize.width)
			posX = screenSize.width - frameSize.width;
		if (posY <= 0)
			posY = 0;
		else if (posY + frameSize.height > screenSize.height)
			posY = screenSize.height - frameSize.height;
		win.setLocation(posX, posY);
		snailAngle += Math.PI / 4.0;
		snailDummy++;
		if (cascadeOriginX <= 0)
			cascadeOriginX = posX;
		if (cascadeOriginY <= 0)
			cascadeOriginY = posY;
	}

	public static void enableComponents(Container c, boolean b) {
		for (int i = 0; i < c.getComponentCount(); i++) {
			c.getComponent(i).setEnabled(b);
			if ((c.getComponent(i) instanceof Container)
					&& ((Container) c).getComponentCount() > 0) {
				enableComponents((Container) c.getComponent(i), b);
			}
		}
	}

	public static void enableComponents(Container c, boolean b,
			Hashtable exceptions) {
		if (!exceptions.contains(c)) {
			for (int i = 0; i < c.getComponentCount(); i++) {
				if (!exceptions.contains(c.getComponent(i))) {
					c.getComponent(i).setEnabled(b);
					if ((c.getComponent(i) instanceof Container)
							&& ((Container) c).getComponentCount() > 0) {
						enableComponents((Container) c.getComponent(i), b,
								exceptions);
					}
				}
			}
		}
	}

	public static void setBounds(Window win, Rectangle r) {
		if (r == null)
			center(win);
		else
			win.setBounds(r);
	}

	public static boolean isInScreen(Window win) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle frameBounds = win.getBounds();
		boolean inScreen = (((frameBounds.x + frameBounds.width) < screenSize.width) && ((frameBounds.y + frameBounds.height) < screenSize.height));
		return inScreen;
	}
}
