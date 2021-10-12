package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;

public class AccountDAO {
	String url = "jdbc:postgresql://localhost:5432/Shop";
	String user = "postgres";
	String password = "postgres";

	public Account findOne(String id, String pass) {
		Account account = null;
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			PreparedStatement pStmt = conn
					.prepareStatement("select * from account where user_id=? and pass=?");
			pStmt.setString(1, id);
			pStmt.setString(2, pass);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				id = rs.getString("USER_ID");
				pass = rs.getString("PASS");
				boolean admin = rs.getBoolean("admin");
				account = new Account(id, pass, admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		System.out.println("アカウントが発見されました");
		return account;
	}
	public Account findOne2(String id) {
		Account account = null;
		try (Connection conn = DriverManager.getConnection(url, user, password)){
			PreparedStatement pStmt = conn.prepareStatement("SELECT * FROM account WHERE user_id=?");
			pStmt.setString(1, id);
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				String user_id = rs.getString("user_id");
				String email = rs.getString("email");
				int postnum = rs.getInt("postnum");
				String address1 = rs.getString("address1");
				String address2 = rs.getString("address2");
				String address3 = rs.getString("address3");
				String address4 = rs.getString("address4");
				int tellnum = rs.getInt("tellnum");
				account=new Account(user_id,email,postnum,address1,address2,address3,address4,tellnum);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}

	public void insertOne(Account account) {
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			PreparedStatement pStmt = conn.prepareStatement(
					"INSERT INTO account(user_id,pass, name1,name2,email,postnum,address1,address2,address3,tellnum,admin) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			pStmt.setString(1, account.getId());
			pStmt.setString(2, account.getPass());
			pStmt.setString(3, account.getName1());
			pStmt.setString(4, account.getName2());
			pStmt.setString(5, account.getEmail());
			pStmt.setInt(6, account.getPostnum());
			pStmt.setString(7, account.getAddress1());
			pStmt.setString(8, account.getAddress2());
			pStmt.setString(9, account.getAddress3());
			pStmt.setInt(10, account.getTelnum());
			pStmt.setBoolean(11, account.getAdmin());
			pStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//セッションスコープにアカウント情報を格納するため

	public void updateOne(Account account) {
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			PreparedStatement pStmt = conn.prepareStatement("UPDATE account SET user_id=?,email=?,tellnum=?,address1=?,address2=?,address3=?,address4=? WHERE user_id =?");
			pStmt.setString(1,account.getId());
			pStmt.setString(2, account.getEmail());
			pStmt.setInt(3, account.getTelnum());
			pStmt.setString(4, account.getAddress1());
			pStmt.setString(5, account.getAddress2());
			pStmt.setString(6, account.getAddress3());
			pStmt.setString(7, account.getAddress4());
			pStmt.setString(8, account.getId());
			pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
