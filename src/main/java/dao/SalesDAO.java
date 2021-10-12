package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Sales;
import model.SalesHistory;

public class SalesDAO {
	String url = "jdbc:postgresql://localhost:5432/Shop";
	String user = "postgres";
	String password = "postgres";

	public void insertOne(Sales sales) {
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			PreparedStatement pStmt = conn.prepareStatement(
					"INSERT INTO sales(user_id,delivery_date,address1,address2,address3,address4,product_code,product_price,quantity) VALUES(?,?,?,?,?,?,?,?,?)");
			pStmt.setString(1, sales.getUser_id());
			pStmt.setDate(2, sales.getDelivery_date());
			pStmt.setString(3, sales.getAddress1());
			pStmt.setString(4, sales.getAddress2());
			pStmt.setString(5, sales.getAddress3());
			pStmt.setString(6, sales.getAddress4());
			pStmt.setInt(7, sales.getProduct_code());
			pStmt.setInt(8, sales.getProduct_price());
			pStmt.setInt(9, sales.getQuantity());
			pStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<SalesHistory> findAllHistory(String account) {
		List<SalesHistory> list = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, user, password)){
			String sql = "select product_info.product_name, sales.product_price, sales.quantity, sales.delivery_date, product_info.images_pass  from sales "
					+ "inner join product_info on sales.product_code = product_info.product_code "
					+ "where user_id = ?;";
			System.out.println("sql準備完了");
			PreparedStatement pStmt = conn.prepareStatement(sql);

			System.out.println("?に" + account + "をいれるよ");
			pStmt.setString(1, account);
			System.out.println(pStmt);
			System.out.println("account成功");

			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				String product_name = rs.getString("product_name");
				int product_price = rs.getInt("product_price");
				int quantity = rs.getInt("quantity");
				Date delivery_date = rs.getDate("delivery_date");
				String images_pass = rs.getString("images_pass");
				list.add(new SalesHistory(product_name, product_price, quantity,delivery_date,images_pass));
				System.out.println("購入リストを追加しました");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
