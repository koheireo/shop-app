package model;

import java.io.Serializable;
import java.sql.Date;

public class Product implements Serializable {
	private int code;
	private int category_code;
	private String name;
	private String size;
	private int price;
	private int stock;
	private String details;
	private Date date;
	private String images_pass;

	public Product() {
	}

	public Product(int code, int category_code, String name, String size, int price, int stock, String details,
			Date date, String images_pass) {
		super();
		this.code = code;
		this.category_code = category_code;
		this.name = name;
		this.size = size;
		this.price = price;
		this.stock = stock;
		this.details = details;
		this.date = date;
		this.images_pass = images_pass;
	}



	public Product(int category_code, String name, String size, int price, int stock, String details,
			Date date,String images_pass) {
		super();
		this.category_code = category_code;
		this.name = name;
		this.size = size;
		this.price = price;
		this.stock = stock;
		this.details = details;
		this.date = date;
		this.images_pass = images_pass;
	}

	public Product(int code, String name, int price, String images_pass) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.images_pass = images_pass;
	}


	public Product(String name, int price, String images_pass) {
		super();
		this.name = name;
		this.price = price;
		this.images_pass = images_pass;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getCategory_code() {
		return category_code;
	}

	public void setCategory_code(int category_code) {
		this.category_code = category_code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getImages_pass() {
		return images_pass;
	}

	public void setImages_pass(String images_pass) {
		this.images_pass = images_pass;
	}

}
