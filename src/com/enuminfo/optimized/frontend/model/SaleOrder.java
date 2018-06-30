/**
 * 
 */
package com.enuminfo.optimized.frontend.model;

import java.util.List;

/**
 * @author Kumar
 */
public class SaleOrder extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String orderDate;
	private String orderNumber;
	private String cId;
	private String cName;
	private List<OrderLine> orderLines;
	private double orderAmount;

	public SaleOrder() {
		// TODO Auto-generated constructor stub
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getCId() {
		return cId;
	}

	public void setCId(String cId) {
		this.cId = cId;
	}

	public String getCName() {
		return cName;
	}

	public void setCName(String cName) {
		this.cName = cName;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}
}
