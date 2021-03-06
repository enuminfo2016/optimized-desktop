/**
 * 
 */
package com.enuminfo.optimized.backend.model;

/**
 * @author AKURATI
 */
public class Bank extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String ifsc;
	private String micr;
	private String branch;
	private String address;
	private String contact;
	private String email;
	
	public Bank() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMicr() {
		return micr;
	}

	public void setMicr(String micr) {
		this.micr = micr;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
}
