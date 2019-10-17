/*
 * 
 */
package com.enuminfo.optimized.framework;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * @author AKURATI
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class EntityTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List columns;
	private List data;

	public EntityTableModel() {
		this(new ArrayList());
	}

	public EntityTableModel(List data) {
		this.data = data;
		this.columns = new ArrayList();
	}

	private void addColumnToList(EntityTableColumn column) {
		if (!columns.contains(column)) {
			columns.add(column);
		}
	}

	public void addColumn(EntityTableColumn column) {
		addColumnToList(column);
	}

	public EntityTableColumn getColumn(int index) {
		return (EntityTableColumn) columns.get(index);
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public int getColumnCount() {
		return columns.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		EntityTableColumn column = getColumn(columnIndex);
		Object obj = data.get(rowIndex);
		return column.getValue(obj);
	}

	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		EntityTableColumn column = getColumn(columnIndex);
		Object obj = data.get(rowIndex);
		column.setValue(obj, value);
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return getColumn(columnIndex).isEditable();
	}

	@Override
	public String getColumnName(int columnIndex) {
		return getColumn(columnIndex).getTitle();
	}

	@Override
	public Class getColumnClass(int columnIndex) {
		return getColumn(columnIndex).getClassType();
	}

	public Object getRowAt(int rowIndex) {
		return data.get(rowIndex);
	}

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}
}
