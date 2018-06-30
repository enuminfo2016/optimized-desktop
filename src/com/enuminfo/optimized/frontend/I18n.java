/*
 * 
 */
package com.enuminfo.optimized.frontend;

import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Kumar
 */
public enum I18n {

	COMPONENT("component"), COMMON("common"), OPTIMIZED("optimized");

	private final ResourceBundle resourceBundle;
	private static final String DEFAULT_LOCATION = "com.enuminfo.optimized.frontend.resources.i18n.";
	private final static Logger LOGGER = Logger.getLogger(I18n.class.getName());

	I18n(String bundleFile) {
		resourceBundle = ResourceBundle.getBundle(DEFAULT_LOCATION + bundleFile);
	}

	public String getString(String key) {
		try {
			return resourceBundle.getString(key);
		} catch (MissingResourceException ex) {
			LOGGER.log(Level.SEVERE, null, ex);
			return "err#";
		}
	}
}
