/*
 * 
 */
package com.enuminfo.optimized.frontend.framework;

import java.awt.Component;

/**
 * @author Kumar
 */
public interface View {

	String getTitle();

	String getIconPath();

	Component asComponent();
}
