package model;

import java.sql.Date;

public class Cart {
	private String user_id;
	private int product_code;
	private String images_pass;
	private Date date;

	//カート情報を見るときに使う
	private String product_name;
	private int product_price;
	private Date entry_date;

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

	public Date getEntry_date() {
		return entry_date;
	}

	public void setEntry_date(Date entry_date) {
		this.entry_date = entry_date;
	}

	public String getImages_pass() {
		return images_pass;
	}

	public Cart(String user_id, int product_code, String images_pass, Date date) {
		super();
		this.user_id = user_id;
		this.product_code = product_code;
		this.images_pass = images_pass;
		this.date = date;
	}

	public void setImages_pass(String images_pass) {
		this.images_pass = images_pass;
	}

	public Cart() {
		super();
	}

	public Cart(String images_pass, String product_name, int product_price, Date entry_date) {
		super();
		this.images_pass = images_pass;
		this.product_name = product_name;
		this.product_price = product_price;
		this.entry_date = entry_date;
	}

	public Cart(String user_id, int product_code, Date date) {
		super();
		this.user_id = user_id;
		this.product_code = product_code;
		this.date = date;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getProduct_code() {
		return product_code;
	}

	public void setProduct_code(int product_code) {
		this.product_code = product_code;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
