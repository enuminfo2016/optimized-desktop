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
 * Order Line Entity
 * @author Kumar
 */
@Entity
@Table (name = TableType.ORDER_LINE)
@NamedQueries ({ 
	@NamedQuery (name = OrderLineEntity.FIND_ALL, query = "SELECT entity FROM OrderLineEntity entity")
})
@AttributeOverride (name = ColumnType.ID, column = @Column (name = ColumnType.ID))
public class OrderLineEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String FIND_ALL = "OrderLine.FindAll";
	
	@ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn (name = ColumnType.PRODUCT)
	private ProductEntity product;
	
	@Column (name = ColumnType.QUANTITY)
	private Double quantity;
	
	@Column (name = ColumnType.UNIT_PRICE)
	private Double unitPrice;
	
	@ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn (name = ColumnType.SALE_ORDER)
	private SaleOrderEntity saleOrder;
	
	public OrderLineEntity() {
		// TODO Auto-generated constructor stub
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
}
