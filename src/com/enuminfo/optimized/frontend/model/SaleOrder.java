/**
 * Optimized Java Swing Application Demo
 * Copyright(c) 2018, enuminfo.com
 */
package com.enuminfo.optimized.frontend.model;

import java.util.List;

/**
 * Sale Order Form
 * @author Kumar
 */
public class SaleOrder extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String orderNumber;
	private String customer;
	private List<OrderLine> orderLines;
	private double orderAmount;
	
	public SaleOrder() {
		// TODO Auto-generated constructor stub
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
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
