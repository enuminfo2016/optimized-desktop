/**
 * 
 */
package com.enuminfo.optimized.frontend.component;

import java.io.Serializable;

/**
 * @author Kumar
 */
public class ComboBoxItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String key;
	private String value;

	public ComboBoxItem() {
		// TODO Auto-generated constructor stub
	}

	public ComboBoxItem(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object object) {
		if (object == null)
			return false;
		if (!(object instanceof ComboBoxItem))
			return false;
		return getKey().equals(((ComboBoxItem) object).getKey());
	}

	@Override
	public String toString() {
		return value;
	}
}
