/**
 * 
 */
package com.enuminfo.optimized.backend.model;

import java.io.Serializable;

/**
 * @author AKURATI
 */
public abstract class Base implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private boolean status;

	public Base() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
