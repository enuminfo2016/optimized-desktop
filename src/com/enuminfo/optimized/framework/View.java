/*
 * 
 */
package com.enuminfo.optimized.framework;

import java.awt.Component;

/**
 * @author AKURATI
 */
public interface View {

	String getTitle();

	String getIconPath();

	Component asComponent();
}
