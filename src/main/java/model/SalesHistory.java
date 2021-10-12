package model;

import java.sql.Date;

public class SalesHistory {
	private String product_name;
	private int product_price;
	private int quantity;
	private Date delivery_date;
	private String images_pass;
	public SalesHistory() {};
	public SalesHistory(String product_name, int product_price, int quantity, Date delivery_date, String images_pass) {
		super();
		this.product_name = product_name;
		this.product_price = product_price;
		this.quantity = quantity;
		this.delivery_date = delivery_date;
		this.images_pass = images_pass;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getDelivery_date() {
		return delivery_date;
	}
	public void setDelivery_date(Date delivery_date) {
		this.delivery_date = delivery_date;
	}
	public String getImages_pass() {
		return images_pass;
	}
	public void setImages_pass(String images_pass) {
		this.images_pass = images_pass;
	}
}
