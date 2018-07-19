/*
 * 
 */
package com.enuminfo.optimized.frontend.contoller;

import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.jvnet.lafwidget.LafWidget;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.api.SubstanceConstants.TabContentPaneBorderKind;
import org.jvnet.substance.skin.SubstanceOfficeBlue2007LookAndFeel;

import com.enuminfo.optimized.backend.AbstractConnectionPool;
import com.enuminfo.optimized.backend.PostgresConnectionPool;
import com.enuminfo.optimized.frontend.I18n;
import com.enuminfo.optimized.frontend.component.MessageBox;
import com.enuminfo.optimized.frontend.component.Splash;
import com.enuminfo.optimized.frontend.view.AppView;

/**
 * @author Kumar
 */
public abstract class AppController {

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
			UIManager.setLookAndFeel(new SubstanceOfficeBlue2007LookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			MessageBox.showError("Substance Look and Feel Error", e);
		}
		UIManager.put(SubstanceLookAndFeel.TABBED_PANE_CONTENT_BORDER_KIND, TabContentPaneBorderKind.DOUBLE_PLACEMENT);
		UIManager.put(LafWidget.TEXT_EDIT_CONTEXT_MENU, true);
		try {
			AbstractConnectionPool.setInstance(new PostgresConnectionPool());
		} catch (SQLException e) {
			MessageBox.showError("MySQL Error", e);
		}
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
		AbstractConnectionPool.getInstance().closeAllConnections();
		System.exit(0);
	}
}
