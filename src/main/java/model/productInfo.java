package model;

import java.io.Serializable;

public class productInfo implements Serializable {
	//商品情報テーブル（商品コードと登録日は自動入力のため省く）

	private int productCode; //商品コード
	private String productName; //商品名
	private String cateCode; //カテゴリーコード
	private String size; //サイズ
	private String productDetails; //商品詳細
	private int price; //単価
	private int stock; //在庫数
	private String entryDate; //登録日
	private String imagesPass; //画像ファイルパス
	private String imagesPass2;
	private String imagesPass3;

	//コンストラクタ
	public productInfo() {
	}

	//引数ありコンンストラクタ
	public productInfo(String productName, String cateCode, String size, String productDetails, int price, int stock,
			String imagesPass, String imagesPass2, String imagesPass3) {

		this.productName = productName;
		this.cateCode = cateCode;
		this.size = size;
		this.productDetails = productDetails;
		this.price = price;
		this.stock = stock;
		this.imagesPass = imagesPass;
		this.imagesPass2 = imagesPass2;
		this.imagesPass3 = imagesPass3;

	}

	public productInfo(int productCode,String cateCode, String productName,  String size, String productDetails,
			int price, int stock, String entryDate, String imagesPass) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.cateCode = cateCode;
		this.size = size;
		this.productDetails = productDetails;
		this.price = price;
		this.stock = stock;
		this.entryDate = entryDate;
		this.imagesPass = imagesPass;
	}

	public productInfo(int productCode, String productName, String cateCode, String size, String productDetails,
			int price, int stock, String entryDate, String imagesPass, String imagesPass2, String imagesPass3) {

		this.productCode = productCode;
		this.productName = productName;
		this.cateCode = cateCode;
		this.size = size;
		this.productDetails = productDetails;
		this.price = price;
		this.stock = stock;
		this.entryDate = entryDate;
		this.imagesPass = imagesPass;
		this.imagesPass2 = imagesPass2;
		this.imagesPass3 = imagesPass3;

	}

	public productInfo(int productCode, String productName, String productDetails, int price, int stock) {

		this.productCode = productCode;
		this.productName = productName;
		this.productDetails = productDetails;
		this.price = price;
		this.stock = stock;

	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCateCode() {
		return cateCode;
	}

	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
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

	public String getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(String productDetails) {
		this.productDetails = productDetails;
	}

	public String getImagesPass() {
		return imagesPass;
	}

	public void setImagesPass(String imagesPass) {
		this.imagesPass = imagesPass;
	}

	public String getImagesPass2() {
		return imagesPass2;
	}

	public void setImagesPass2(String imagesPass2) {
		this.imagesPass2 = imagesPass2;
	}

	public String getImagesPass3() {
		return imagesPass3;
	}

	public void setImagesPass3(String imagesPass3) {
		this.imagesPass3 = imagesPass3;
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

}
