/**
 * Optimized Java Swing Application Demo
 * Copyright(c) 2018, enuminfo.com
 */
package com.enuminfo.optimized.backend.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.enuminfo.optimized.backend.ColumnType;
import com.enuminfo.optimized.backend.TableType;

/**
 * Bank Entity
 * @author Kumar
 */
@Entity
@Table (name = TableType.BANK)
@NamedQueries ({ 
	@NamedQuery (name = BankEntity.FIND_ALL, query = "SELECT entity FROM BankEntity entity"),
	@NamedQuery (name = BankEntity.FIND_BY_NAME, query = "SELECT entity FROM BankEntity entity WHERE entity.name LIKE :name") 
})
@AttributeOverride (name = ColumnType.ID, column = @Column (name = ColumnType.ID))
public class BankEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String FIND_ALL = "Bank.FindAll";
	public static final String FIND_BY_NAME = "Bank.FindByName";

	@Column (name = ColumnType.NAME)
	private String name;

	@Column (name = ColumnType.IFSC)
	private String ifsc;
	
	@Column (name = ColumnType.MICR)
	private String micr;
	
	@Column (name = ColumnType.BRANCH)
	private String branch;
	
	@Column (name = ColumnType.ADDRESS)
	private String address;
	
	@Column (name = ColumnType.CONTACT)
	private String contact;
	
	public BankEntity() {
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

	public String getMicr() {
		return micr;
	}

	public void setMicr(String micr) {
		this.micr = micr;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
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
}
