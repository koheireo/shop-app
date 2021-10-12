package model;

import java.io.Serializable;
import java.sql.Date;

public class Sales implements Serializable {
	private String user_id;
	private Date delivery_date;
	private String address1;
	private String address2;
	private String address3;
	private String address4;
	private int product_code;
	private int product_price;
	private int quantity;


	public Sales() {}


	public Sales(String user_id, Date delivery_date, String address1, String address2, String address3, String address4,
			int product_code, int product_price, int quantity) {
		super();
		this.user_id = user_id;
		this.delivery_date = delivery_date;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.address4 = address4;
		this.product_code = product_code;
		this.product_price = product_price;
		this.quantity = quantity;
	}


	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Date getDelivery_date() {
		return delivery_date;
	}
	public void setDelivery_date(Date delivery_date) {
		this.delivery_date = delivery_date;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getAddress3() {
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	public String getAddress4() {
		return address4;
	}
	public void setAddress4(String address4) {
		this.address4 = address4;
	}
	public int getProduct_code() {
		return product_code;
	}
	public void setProduct_code(int product_code) {
		this.product_code = product_code;
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
}
