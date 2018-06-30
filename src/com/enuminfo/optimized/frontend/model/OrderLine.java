/**
 * 
 */
package com.enuminfo.optimized.frontend.model;

/**
 * @author Kumar
 */
public class OrderLine extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String product;
	private double quantity;
	private double unitPrice;
	private double totalPrice;

	public OrderLine() {
		// TODO Auto-generated constructor stub
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
}
