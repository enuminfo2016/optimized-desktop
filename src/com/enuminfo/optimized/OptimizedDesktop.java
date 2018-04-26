/*
 * Optimized Java Swing Application Demo
 * Copyright(c) 2018, enuminfo.com
 */
package com.enuminfo.optimized;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.SwingUtilities;

import com.enuminfo.optimized.frontend.I18n;
import com.enuminfo.optimized.frontend.ViewHelpers;
import com.enuminfo.optimized.frontend.component.Splash;
import com.enuminfo.optimized.frontend.contoller.AppController;

/**
 * Optimized desktop application.
 * @author Kumar
 */
public class OptimizedDesktop extends AppController {

	private final static Logger LOGGER = Logger.getLogger(OptimizedDesktop.class.getName());

	public static Splash splash;
	
	public OptimizedDesktop() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		
		// set locale for i18n
		Locale.setDefault(new Locale("en", "US"));
		
		splash = new Splash(I18n.OPTIMIZED.getString("App.Title"), ViewHelpers.ICONS16 + "app.png",
				ViewHelpers.IMAGES + "splash.png");
		splash.setVisible(true);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ex) {
			LOGGER.log(Level.SEVERE, null, ex);
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
