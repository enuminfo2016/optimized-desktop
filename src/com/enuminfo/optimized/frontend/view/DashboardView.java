/**
 * Optimized Java Swing Application Demo
 * Copyright(c) 2018, enuminfo.com
 */
package com.enuminfo.optimized.frontend.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jdesktop.swingx.JXHyperlink;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.painter.decoration.DecorationAreaType;

import com.enuminfo.optimized.framework.PageController;
import com.enuminfo.optimized.framework.PageView;
import com.enuminfo.optimized.frontend.I18n;
import com.enuminfo.optimized.frontend.ViewHelpers;
import com.enuminfo.optimized.frontend.contoller.AppController;
import com.enuminfo.optimized.frontend.contoller.DashboardController;

import net.miginfocom.swing.MigLayout;

/**
 * Dashboard Page View
 * 
 * @author Kumar
 */
public class DashboardView implements PageView {

	private JPanel pageView;
	private PageController controller;

	public DashboardView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTitle() {
		return I18n.OPTIMIZED.getString("Dashboard.Home.Dashboard");
	}

	@Override
	public String getIconPath() {
		return ViewHelpers.ICONS16 + "dashboard.png";
	}

	@Override
	public Component asComponent() {
		return pageView;
	}

	@Override
	public void init(PageController controller) {
		this.controller = controller;
		initComponents();
	}

	private void initComponents() {
		pageView = new JPanel(new BorderLayout());
		pageView.add(getHeaderBar(), BorderLayout.NORTH);
		pageView.add(getCenterPanel(), BorderLayout.CENTER);
	}

	@SuppressWarnings("serial")
	private Component getCenterPanel() {
		JPanel centerPanel = new JPanel(new MigLayout("insets 200 200 200 200"));

		int productsCount = ((DashboardController) getController()).getProductsCount();
		int customersCount = ((DashboardController) getController()).getCustomersCount();

		JPanel productItem = createItemPanel(ViewHelpers.IMAGES + "category.png",
				I18n.OPTIMIZED.getString("Dashboard.Home.LinkProducts") + " (" + productsCount + ")",
				new AbstractAction() {
					@Override
					public void actionPerformed(ActionEvent e) {
						AppController.get().getView().onOpenProducts();
					}
				});

		JPanel customerItem = createItemPanel(ViewHelpers.IMAGES + "customer.png",
				I18n.OPTIMIZED.getString("Dashboard.Home.LinkCustomers") + " (" + customersCount + ")",
				new AbstractAction() {
					@Override
					public void actionPerformed(ActionEvent e) {
						AppController.get().getView().onOpenCustomers();
					}
				});

		centerPanel.add(productItem, "gapright 70");
		centerPanel.add(customerItem, "gapright 70");
		return centerPanel;
	}

	private JPanel createItemPanel(String iconPath, String title, final AbstractAction openAction) {
		JPanel itemPanel = new JPanel(new BorderLayout());

		JLabel lblItem = new JLabel(new ImageIcon(getClass().getResource(iconPath)));
		lblItem.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				openAction.actionPerformed(null);
			}
		});

		JXHyperlink link = new JXHyperlink(openAction);
		link.setText(title);

		itemPanel.add(lblItem, BorderLayout.NORTH);
		itemPanel.add(link, BorderLayout.SOUTH);
		return itemPanel;
	}

	private Component getHeaderBar() {
		JPanel headerBar = new JPanel(new MigLayout("insets 2 2 2 2"));

		JLabel lblTitle = new JLabel(getTitle());
		lblTitle.setIcon(new ImageIcon(getClass().getResource(getIconPath())));
		lblTitle.setFont(lblTitle.getFont().deriveFont(Font.BOLD, 14));

		headerBar.setPreferredSize(new Dimension(lblTitle.getWidth(), lblTitle.getHeight() + 28));
		headerBar.add(lblTitle, "dock center, gapleft 4");

		SubstanceLookAndFeel.setDecorationType(headerBar, DecorationAreaType.HEADER);
		return headerBar;
	}

	@Override
	public PageController getController() {
		return controller;
	}
}
