package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.productInfo;



public class ShopDAO {
	//データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:postgresql://localhost:5432/Shop";
	private final String DB_USER = "postgres";
	private final String DB_PASS = "postgres";


		public boolean entryInput(productInfo productinfo) {
		//データベースに接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			//INSERT文準備
			String sql = "INSERT INTO PRODUCT_INFO"
					+ "(PRODUCT_NAME,CATE_CODE,SIZE,PRODUCT_DETAILS,PRICE,STOCK,ENTRY_DATE,IMAGES_PASS,IMAGES_PASS2,IMAGES_PASS3)"
					+ "VALUES(?,?,?,?,?,?,CURRENT_DATE,?,?,?)";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,productinfo.getProductName());
			pStmt.setString(2,productinfo.getCateCode());
			pStmt.setString(3,productinfo.getSize());
			pStmt.setString(4,productinfo.getProductDetails());
			pStmt.setInt(5,productinfo.getPrice());
			pStmt.setInt(6,productinfo.getStock());
			pStmt.setString(7,productinfo.getImagesPass());
			pStmt.setString(8,productinfo.getImagesPass2());
			pStmt.setString(9,productinfo.getImagesPass3());

			//INSERT文を実行
			pStmt.executeUpdate();

			return true;


			} catch(SQLException e) {
				e.printStackTrace();
				return false;

			}

	}
		public boolean updateInput(productInfo productinfo2) {
		//データベースに接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			//INSERT文準備
			String sql = "UPDATE PRODUCT_INFO"
					+ "SET PRODUCT_NAME=?,PRODUCT_DETAILS=?,PRICE=?,STOCK=?"
					+ "WHERE PRODUCT_CODE=?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1,productinfo2.getProductCode());
			pStmt.setString(2,productinfo2.getProductName());
			pStmt.setString(3,productinfo2.getProductDetails());
			pStmt.setInt(4,productinfo2.getPrice());
			pStmt.setInt(5,productinfo2.getStock());


			//UPDATE文を実行
			pStmt.executeUpdate();

			return true;


			} catch(SQLException e) {
				e.printStackTrace();
				return false;

			}

	}
		public List<productInfo> update(){
			   List<productInfo> Shohin_List = new LinkedList<productInfo>();

			//データベースに接続
			try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			//SELECT文準備
				String sql = "SELECT PRODUCT_CODE,PRODUCT_NAME,CATE1,SIZE,PRODUCT_DETAILS,PRICE,STOCK,ENTRY_DATE,IMAGES_PASS,IMAGES_PASS2,IMAGES_PASS3 FROM  PRODUCT_INFO,CATEGORY WHERE PRODUCT_INFO.CATE_CODE = CATEGORY.CATE_CODE ORDER BY PRODUCT_CODE DESC";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				//SELECTを実行
				ResultSet rs = pStmt.executeQuery();

				//SELECT文の結果をArrayListに格納
				while(rs.next()) {
					int productCode = rs.getInt("product_code");
					String productName = rs.getString("product_name");
					String cateCode = rs.getString("cate1");
					String size = rs.getString("size");
					String productDetails = rs.getString("product_details");
					int price = rs.getInt("price");
					int stock = rs.getInt("stock");
					String entryDate = rs.getString("entry_date");
					String imagesPass = rs.getString("images_pass");
					String imagesPass2 = rs.getString("images_pass2");
					String imagesPass3 = rs.getString("images_pass3");

					productInfo Shohin = new productInfo(productCode,productName,cateCode,size,productDetails,price,stock,entryDate,imagesPass,imagesPass2,imagesPass3);
					Shohin_List.add(Shohin);
				}
			}
				 catch(SQLException e) {
					e.printStackTrace();
					return null;
				}return Shohin_List;

		}
}









