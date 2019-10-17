/*
 * 
 */
package com.enuminfo.optimized.framework;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;

import org.jvnet.substance.api.ColorSchemeAssociationKind;
import org.jvnet.substance.api.ComponentState;
import org.jvnet.substance.api.SubstanceColorScheme;
import org.jvnet.substance.utils.SubstanceColorSchemeUtilities;

import com.enuminfo.optimized.backend.model.Base;
import com.enuminfo.optimized.uitl.I18n;
import com.enuminfo.optimized.uitl.ViewHelpers;

/**
 * @author AKURATI
 */
public abstract class AbstractPreviewPanel<T extends Base> extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private T model;

	public AbstractPreviewPanel() {
		initComponents();
	}

	public void setModel(T model) {
		this.model = model;
		popFields();
	}

	public T getModel() {
		return model;
	}

	public abstract void buildUI();

	public abstract void popFields();

	private void initComponents() {
		setLayout(new BorderLayout());
		setFocusable(false);
		SubstanceColorScheme borderColorScheme = SubstanceColorSchemeUtilities.getColorScheme(this,
				ColorSchemeAssociationKind.BORDER, ComponentState.DEFAULT);
		setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, borderColorScheme.getDarkColor()));
		JToolBar tbHeaderBar = new JToolBar();
		tbHeaderBar.setPreferredSize(new Dimension(150, 25));
		JLabel lblCaption = new JLabel(I18n.COMMON.getString("AbstractPreviewPanel.Title"));
		lblCaption.setFont(lblCaption.getFont().deriveFont(Font.BOLD, 14));
		lblCaption.setIcon(new ImageIcon(getClass().getResource(ViewHelpers.ICONS16 + "preview.png")));
		tbHeaderBar.addSeparator();
		tbHeaderBar.add(lblCaption);
		tbHeaderBar.setFloatable(false);
		tbHeaderBar.setRollover(true);
		tbHeaderBar.setFocusable(false);
		add(tbHeaderBar, BorderLayout.NORTH);
		buildUI();
	}

	public void addCenterComponent(JComponent component) {
		add(new JScrollPane(component), BorderLayout.CENTER);
		setPreferredSize(component.getPreferredSize());
	}
}
