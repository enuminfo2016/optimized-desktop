/*
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
 * Category entity
 * @author Kumar
 */
@Entity
@Table (name = TableType.CATEGORY)
@NamedQueries ({ 
	@NamedQuery (name = CategoryEntity.FIND_ALL, query = "SELECT entity FROM CategoryEntity entity"),
	@NamedQuery (name = CategoryEntity.FIND_BY_NAME, query = "SELECT entity FROM CategoryEntity entity WHERE entity.name LIKE :name") 
})
@AttributeOverride (name = ColumnType.ID, column = @Column (name = ColumnType.ID))
public class CategoryEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String FIND_ALL = "Category.FindAll";
	public static final String FIND_BY_NAME = "Category.FindByName";

	@Column (name = ColumnType.NAME)
	private String name;
	
	public CategoryEntity() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
