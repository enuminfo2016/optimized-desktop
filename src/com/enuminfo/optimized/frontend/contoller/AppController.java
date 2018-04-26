/*
 * Optimized Java Swing Application Demo
 * Copyright(c) 2018, enuminfo.com
 */
package com.enuminfo.optimized.frontend.contoller;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.jvnet.lafwidget.LafWidget;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.api.SubstanceConstants.TabContentPaneBorderKind;
import org.jvnet.substance.skin.SubstanceMistAquaLookAndFeel;

import com.enuminfo.optimized.backend.JpaUtil;
import com.enuminfo.optimized.frontend.I18n;
import com.enuminfo.optimized.frontend.component.Splash;
import com.enuminfo.optimized.frontend.view.AppView;

/**
 * Application Controller
 * @author Kumar
 */
public abstract class AppController {

	private final static Logger LOGGER = Logger.getLogger(AppController.class.getName());

	protected static AppController controller;
	protected AppView view;
	private Splash splash;
	
	public AppController() {
		// TODO Auto-generated constructor stub
	}

	public void start() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);

		try {
			UIManager.setLookAndFeel(new SubstanceMistAquaLookAndFeel());
		} catch (UnsupportedLookAndFeelException ex) {
			LOGGER.log(Level.SEVERE, "Substance Look and Feel Error", ex);
		}

		// TabbedPane border settings in substance look and feel.
		UIManager.put(SubstanceLookAndFeel.TABBED_PANE_CONTENT_BORDER_KIND, TabContentPaneBorderKind.DOUBLE_PLACEMENT);

		// Cut, copy, paste menu in TextField with substance look and feel.
		UIManager.put(LafWidget.TEXT_EDIT_CONTEXT_MENU, true);

		if (splash != null) {
			splash.setVisible(false);
			splash.dispose();
		}

		view = new AppView(I18n.OPTIMIZED.getString("App.Title"));
		view.setVisible(true);
	}

	public static AppController get() {
		return controller;
	}

	public AppView getView() {
		return view;
	}

	public void setSplash(Splash splash) {
		this.splash = splash;
	}

	public void exit() {
		JpaUtil.closeEntityManagerFactory();
		System.exit(0);
	}
}
