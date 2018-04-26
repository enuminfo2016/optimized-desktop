/*
 * Optimized Java Swing Application Demo
 * Copyright(c) 2018, enuminfo.com
 */
package com.enuminfo.optimized.framework;

import java.awt.Component;

/**
 * View interface.
 * @author Kumar
 */
public interface View {

	String getTitle();
	String getIconPath();
	Component asComponent();
}
