/*
 * Optimized Java Swing Application Demo
 * Copyright(c) 2018, enuminfo.com
 */
package com.enuminfo.optimized.framework;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Entity table column model
 * 
 * @author Kumar
 */
@SuppressWarnings("rawtypes")
public class EntityTableColumn {

	private static final Logger LOGGER = Logger.getLogger(EntityTableColumn.class.getName());

	private String title;
	private String fieldName;
	private Class classType;
	private int width;
	private boolean editable;
	private boolean visible;

	public EntityTableColumn(String title, String fieldName, Class classType, int width) {
		this(title, fieldName, classType, width, false, true);
	}

	public EntityTableColumn(String title, String fieldName, Class classType, int width, boolean editable,
			boolean visible) {
		this.title = title;
		this.fieldName = fieldName;
		this.classType = classType;
		this.width = width;
		this.editable = editable;
		this.visible = visible;
	}

	public Object getValue(Object entity) {
		try {
			Field field = entity.getClass().getDeclaredField(getFieldName());
			field.setAccessible(true);
			try {
				return field.get(entity);
			} catch (IllegalArgumentException | IllegalAccessException ex) {
				LOGGER.log(Level.SEVERE, null, ex);
			}
		} catch (NoSuchFieldException | SecurityException ex) {
			LOGGER.log(Level.SEVERE, null, ex);
		}
		return null;
	}

	public void setValue(Object entity, Object value) {
		try {
			Field field = entity.getClass().getDeclaredField(getFieldName());
			field.setAccessible(true);
			field.set(entity, value);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
			LOGGER.log(Level.SEVERE, null, ex);
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Class getClassType() {
		return classType;
	}

	public void setClassType(Class classType) {
		this.classType = classType;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}
