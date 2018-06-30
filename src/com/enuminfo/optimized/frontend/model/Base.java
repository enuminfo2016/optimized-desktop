/**
 * 
 */
package com.enuminfo.optimized.frontend.model;

import java.io.Serializable;

/**
 * @author Kumar
 */
public abstract class Base implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;

	public Base() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
