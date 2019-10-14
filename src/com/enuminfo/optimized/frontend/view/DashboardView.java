/**
 * 
 */
package com.enuminfo.optimized.frontend.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.painter.decoration.DecorationAreaType;

import com.enuminfo.optimized.frontend.I18n;
import com.enuminfo.optimized.frontend.ViewHelpers;
import com.enuminfo.optimized.frontend.framework.PageController;
import com.enuminfo.optimized.frontend.framework.PageView;

import net.miginfocom.swing.MigLayout;

/**
 * @author Kumar
 */
public class DashboardView implements PageView {

	private JPanel pageView;
	private PageController controller;

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

	private Component getCenterPanel() {
		JPanel centerPanel = new JPanel(new MigLayout("insets 200 200 200 200"));
		return centerPanel;
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
