/*
 * 
 */
package com.enuminfo.optimized.frontend;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.jvnet.lafwidget.LafWidget;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.api.SubstanceConstants.TabContentPaneBorderKind;
import org.jvnet.substance.skin.SubstanceModerateLookAndFeel;

import com.enuminfo.optimized.backend.thread.BankExcelThread;
import com.enuminfo.optimized.backend.thread.CountryExcelThread;
import com.enuminfo.optimized.backend.thread.LocationExcelThread;
import com.enuminfo.optimized.frontend.component.MessageBox;
import com.enuminfo.optimized.frontend.component.Splash;
import com.enuminfo.optimized.uitl.I18n;

/**
 * @author AKURATI
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
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
			FutureTask[] tasks = new FutureTask[5];
			tasks[0] = new FutureTask(new CountryExcelThread());
			tasks[1] = new FutureTask<>(new LocationExcelThread());
			tasks[2] = new FutureTask<>(new BankExcelThread());
			for (int i = 0; i < tasks.length; i++) {
				if (tasks[i] != null) {
					new Thread(tasks[i]).start();
					try {
						System.out.println(tasks[i].get());
					} catch (InterruptedException | ExecutionException e) {
						e.printStackTrace();
					}
				}
			}
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
