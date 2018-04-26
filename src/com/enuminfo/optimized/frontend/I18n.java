/*
 * Optimized Java Swing Application Demo
 * Copyright(c) 2018, enuminfo.com
 */
package com.enuminfo.optimized.frontend;

import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Resource Bundle helper.
 * <p>
 * Each module has its own resource bundle file for i18n strings. Always read
 * default locale from <code>Locale.getDefault()</code>.
 * <p>
 * <pre>
 * I18n.MODULE_NAME.getString("stringKey");
 * </pre>
 * @see ResourceBundle
 * @author Kumar
 */
public enum I18n {

	COMPONENT("component"),
	COMMON("common"),
	OPTIMIZED("optimized");

	private final ResourceBundle resourceBundle;
	private static final String DEFAULT_LOCATION = "com.enuminfo.optimized.resources.i18n.";
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
