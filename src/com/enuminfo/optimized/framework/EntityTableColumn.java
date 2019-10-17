/*
 * 
 */
package com.enuminfo.optimized.framework;

import java.lang.reflect.Field;

import com.enuminfo.optimized.frontend.component.MessageBox;

/**
 * @author AKURATI
 */
@SuppressWarnings("rawtypes")
public class EntityTableColumn {

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
			return field.get(entity);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			MessageBox.showError(e.getMessage(), e);
		}
		return null;
	}

	public void setValue(Object entity, Object value) {
		try {
			Field field = entity.getClass().getDeclaredField(getFieldName());
			field.setAccessible(true);
			field.set(entity, value);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			MessageBox.showError(e.getMessage(), e);
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
