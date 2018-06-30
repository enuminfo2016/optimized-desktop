/**
 * 
 */
package com.enuminfo.optimized.backend.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.enuminfo.optimized.backend.ColumnType;
import com.enuminfo.optimized.backend.TableType;

/**
 * @author Kumar
 */
@Entity
@Table(name = TableType.SALE_ORDER)
@NamedQueries({ @NamedQuery(name = SaleOrderEntity.FIND_ALL, query = "SELECT entity FROM SaleOrderEntity entity") })
@AttributeOverride(name = ColumnType.ID, column = @Column(name = ColumnType.ID))
public class SaleOrderEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String FIND_ALL = "SaleOrder.FindAll";

	@Column(name = ColumnType.ORDER_NUMBER)
	private String orderNumber;

	@Column(name = ColumnType.ORDER_DATE)
	@Temporal(TemporalType.DATE)
	private Date orderDate;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = ColumnType.CUSTOMER)
	private CustomerEntity customer;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = ColumnType.ORDER_LINES)
	private Collection<OrderLineEntity> orderLines;

	public SaleOrderEntity() {
		// TODO Auto-generated constructor stub
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public Collection<OrderLineEntity> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(Collection<OrderLineEntity> orderLines) {
		this.orderLines = orderLines;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
}
