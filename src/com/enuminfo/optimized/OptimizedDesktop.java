/*
 * 
 */
package com.enuminfo.optimized;

import java.util.Locale;

import javax.swing.SwingUtilities;

import com.enuminfo.optimized.frontend.AppController;
import com.enuminfo.optimized.frontend.component.MessageBox;
import com.enuminfo.optimized.frontend.component.Splash;
import com.enuminfo.optimized.uitl.I18n;
import com.enuminfo.optimized.uitl.ViewHelpers;

/**
 * @author AKURATI
 */
public class OptimizedDesktop extends AppController {

	public static Splash splash;

	public static void main(String[] args) {
		Locale.setDefault(new Locale("en", "US"));
		splash = new Splash(I18n.OPTIMIZED.getString("App.Title"), ViewHelpers.ICONS16 + "app.png",
				ViewHelpers.IMAGES + "splash.png");
		splash.setVisible(true);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			MessageBox.showError(e.getMessage(), e);
		}
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				controller = new OptimizedDesktop();
				controller.setSplash(splash);
				controller.start();
			}
		});
	}
}
