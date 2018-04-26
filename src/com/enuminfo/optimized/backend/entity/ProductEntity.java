/**
 * Optimized Java Swing Application Demo
 * Copyright(c) 2018, enuminfo.com
 */
package com.enuminfo.optimized.backend.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.enuminfo.optimized.backend.ColumnType;
import com.enuminfo.optimized.backend.TableType;

/**
 * Product Entity
 * @author Kumar
 */
@Entity
@Table (name = TableType.PRODUCT)
@NamedQueries ({ 
	@NamedQuery (name = ProductEntity.FIND_ALL, query = "SELECT entity FROM ProductEntity entity"),
	@NamedQuery (name = ProductEntity.FIND_BY_CODE, query = "SELECT entity FROM ProductEntity entity WHERE entity.code LIKE :code") 
})
@AttributeOverride (name = ColumnType.ID, column = @Column (name = ColumnType.ID))
public class ProductEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String FIND_ALL = "Product.FindAll";
	public static final String FIND_BY_CODE = "Product.FindByCode";
	
	@Column (name = ColumnType.NAME)
	private String name;
	
	@Column (name = ColumnType.SKU_CODE)
	private String code;
	
	@ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn (name = ColumnType.CATEGORY)
	private CategoryEntity category;
	
	public ProductEntity() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}
}
