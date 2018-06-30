/*
 * 
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
 * @author Kumar
 */
@Entity
@Table(name = TableType.COUNTRY)
@NamedQueries({ @NamedQuery(name = CountryEntity.FIND_ALL, query = "SELECT entity FROM CountryEntity entity"),
		@NamedQuery(name = CountryEntity.FIND_BY_NAME, query = "SELECT entity FROM CountryEntity entity WHERE entity.name LIKE :name") })
@AttributeOverride(name = ColumnType.ID, column = @Column(name = ColumnType.ID))
public class CountryEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String FIND_ALL = "Country.FindAll";
	public static final String FIND_BY_NAME = "Country.FindByName";

	@Column(name = ColumnType.NAME)
	private String name;

	@Column(name = ColumnType.ISD)
	private String isd;

	public CountryEntity() {
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
