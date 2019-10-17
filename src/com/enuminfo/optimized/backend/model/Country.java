/**
 * 
 */
package com.enuminfo.optimized.backend.model;

/**
 * @author AKURATI
 */
public class Country extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String isd;
	
	public Country() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsd() {
		return isd;
	}

	public void setIsd(String isd) {
		this.isd = isd;
	}
}
