/*
 * 
 */
package com.enuminfo.optimized.frontend;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.jvnet.lafwidget.LafWidget;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.api.SubstanceConstants.TabContentPaneBorderKind;
import org.jvnet.substance.skin.SubstanceModerateLookAndFeel;

import com.enuminfo.optimized.frontend.component.MessageBox;
import com.enuminfo.optimized.frontend.component.Splash;
import com.enuminfo.optimized.uitl.I18n;

/**
 * @author AKURATI
 */
public abstract class AppController {

	protected static AppController controller;
	protected AppView view;
	private Splash splash;

	public void start() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		try {
			UIManager.setLookAndFeel(new SubstanceModerateLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			MessageBox.showError("Substance Look and Feel Error", e);
		}
		UIManager.put(SubstanceLookAndFeel.TABBED_PANE_CONTENT_BORDER_KIND, TabContentPaneBorderKind.DOUBLE_PLACEMENT);
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
		System.exit(0);
	}
}
