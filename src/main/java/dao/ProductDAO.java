package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;
import model.productInfo;

public class ProductDAO {
	String url = "jdbc:postgresql://localhost:5432/Shop";
	String user = "postgres";
	String password = "postgres";

	public void insertOne(Product product) {
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			PreparedStatement pStmt = conn.prepareStatement(
					"INSERT INTO product(category_code,product_name,size,price,stock,product_details,entry_date,images_pass) VALUES(?,?,?,?,?,?,?,?)");
			pStmt.setInt(1, product.getCategory_code());
			pStmt.setString(2, product.getName());
			pStmt.setString(3, product.getSize());
			pStmt.setInt(4, product.getPrice());
			pStmt.setInt(5, product.getStock());
			pStmt.setString(6, product.getDetails());
			pStmt.setDate(7, product.getDate());
			pStmt.setString(8, product.getImages_pass());
			pStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Product> findAll() {//管理者の画面
		List<Product> list = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, user, password)){
			String sql = "SELECT * FROM product_info ORDER BY product_code ASC";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				int code = rs.getInt("product_code");
				String name = rs.getString("product_name");
				int price = rs.getInt("price");
				String images_pass = rs.getString("images_pass");
				list.add(new Product(code, name, price, images_pass));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Product> find6() {
		List<Product> list = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, user, password)){
			String sql = "SELECT * FROM product_info ORDER BY product_code ASC limit 6 offset 0;";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				int code = rs.getInt("product_code");
				String name = rs.getString("product_name");
				int price = rs.getInt("price");
				String images_pass = rs.getString("images_pass");
				list.add(new Product(code, name, price, images_pass));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Product> find6Limit(int num2) {
		List<Product> list = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, user, password)){
			String sql = "SELECT * FROM product_info ORDER BY product_code ASC limit 6 offset ?;";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, num2);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				int code = rs.getInt("product_code");
				String name = rs.getString("product_name");
				int price = rs.getInt("price");
				String images_pass = rs.getString("images_pass");
				list.add(new Product(code, name, price, images_pass));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Product> findAllback() {
		List<Product> list = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, user, password)){
			String sql = "SELECT * FROM product_info ORDER BY product_code DESC limit 6 offset 0;";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				int code = rs.getInt("product_code");
				String name = rs.getString("product_name");
				int price = rs.getInt("price");
				String images_pass = rs.getString("images_pass");
				list.add(new Product(code, name, price, images_pass));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public productInfo findOne(int id) {
		productInfo product = null;
		try (Connection conn = DriverManager.getConnection(url, user, password)){
			PreparedStatement pStmt = conn.prepareStatement("SELECT * FROM product_info "
					+ "join category on product_info.cate_code = category.cate_code WHERE product_code=?");
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				int product_code = rs.getInt("product_code");
				String category_code = rs.getString("cate1");
				String product_name = rs.getString("product_name");
				String size = rs.getString("size");
				int price =rs.getInt("price");
				int stock = rs.getInt("stock");
				String  product_details = rs.getString("product_details");
				String entry_date = rs.getString("entry_date");
				String images_pass = rs.getString("images_pass");

				product=new productInfo(product_code,category_code,product_name,size,product_details,price,stock,entry_date,images_pass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	public List<Product> search(String keyword) {
		List<Product> list = new ArrayList<>();
		Product product = null;
		try (Connection conn = DriverManager.getConnection(url, user, password)){
			PreparedStatement pStmt = conn.prepareStatement("SELECT * FROM product WHERE product_name like ?");
			pStmt.setString(1,"%" + keyword + "%");
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				int code = rs.getInt("product_code");
				String name = rs.getString("product_name");
				int price = rs.getInt("price");
				String images_pass = rs.getString("images_pass");
				list.add(new Product(code, name, price, images_pass));
			}
			if (list == null || list.size() == 0) {
				return null;
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
