package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cart;

public class CartDAO {
	String url = "jdbc:postgresql://localhost:5432/Shop";
	String user = "postgres";
	String password = "postgres";

	//まだ未完成

	public void insertOne(Cart cart) {
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			PreparedStatement pStmt = conn.prepareStatement(
					"INSERT INTO cart(user_id,product_code,entry_date) VALUES(?,?,?)");
			pStmt.setString(1, cart.getUser_id());
			pStmt.setInt(2, cart.getProduct_code());
			pStmt.setDate(3, cart.getDate());
			pStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Cart> findAll(String cart) {
		List<Cart> list = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, user, password)){
			String sql = "select product_info.product_name, product_info.price, product_info.images_pass, cart.entry_date from cart "
					+ "join account on cart.user_id = account.user_id "
					+ "right join product_info on cart.product_code = product_info.product_code "
					+ "where cart.user_id = ?";
			System.out.println("sql準備完了");
			PreparedStatement pStmt = conn.prepareStatement(sql);

			System.out.println("?に" + cart + "をいれるよ");
			pStmt.setString(1, cart);
			System.out.println(pStmt);
			System.out.println("cart成功");

			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				String product_name = rs.getString("product_name");
				int product_price = rs.getInt("price");
				String images_pass = rs.getString("images_pass");
				Date entry_date = rs.getDate("entry_date");
				System.out.println(entry_date);
				list.add(new Cart(images_pass, product_name, product_price,entry_date));
				System.out.println("カート情報を追加しました");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
