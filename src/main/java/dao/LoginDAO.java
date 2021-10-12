package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.LST;

public class LoginDAO {
	private final String JDBC_URL = "jdbc:postgresql://localhost:5432/Shop";
	private final String DB_USER = "postgres";
	private final String DB_PASS = "postgres";

	public boolean ChkLogin(String Userid) {
		//データベース接続(ユーザがDataBaseに在るか否かのチェック)
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String Userid0 = Userid;

			//SELECT文の準備(DataBase)
			String sql = "SELECT user_id, pass FROM account WHERE user_id = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, Userid0);

			//SELECT文の実行(DataBase)
			ResultSet rs = pStmt.executeQuery();

			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public LST ChkLogin(int id, boolean admin, String userid, String pass) {
		//データベース接続(ユーザ認証の為の抽出確認)
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//SELECT文の準備(DataBase)
			String sql = "SELECT id, admin, user_id, pass FROM account WHERE user_id = ? AND pass = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, userid);
			pStmt.setString(2, pass);

			//SELECT文の実行(DataBase)
			ResultSet rs = pStmt.executeQuery();

			if (rs.next() == true) {
				//テーブルから結果データを取得
				id = rs.getInt("id");
				admin = rs.getBoolean("admin");
				userid = rs.getString("user_id");
				pass = rs.getString("pass");

				//LST型にSQL_SELECT結果を配置
				LST list = new LST(id, admin, userid, pass);
				return list;

			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public LST ChkLogin(int id, boolean admin, String userid, String pass, String name0, String name1,
			String mailadd, String postnum, String address0, String address1, String address2,
			String telnum) {
		//データベース接続(ログイン認証後のレコードを抽出(登録情報確認の為))
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//SELECT文の準備(DataBase)
			/* SELECT抽出文が長くなる為、SQLにてVIEWを作成登録し、それを呼び込む
			 *
			 */
			String sql = "SELECT * FROM account WHERE USERID = ? AND PASS = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, userid);
			pStmt.setString(2, pass);

			//SELECT文の実行(DataBase)
			ResultSet rs = pStmt.executeQuery();

			if (rs.next() == true) {
				//テーブルから結果データを取得
				id = rs.getInt("ID");
				admin = rs.getBoolean("ADMIN");
				userid = rs.getString("USERID");
				pass = rs.getString("PASS");
				//この下使っていないので意味なし
				name0 = rs.getString("NAME0");
				name1 = rs.getString("NAME1");
				mailadd = rs.getString("MAILADD");
				postnum = rs.getString("POSTNUM");
				address0 = rs.getString("ADDRESS0");
				address1 = rs.getString("ADDRESS1");
				address2 = rs.getString("ADDRESS2");
				telnum = rs.getString("TELNUM");

				//LST型にSQL_SELECT結果を配置
				LST list = new LST(id, admin, userid, pass);
				return list;

			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public void Chg(int id, boolean admin, String userid, String pass, String name0, String name1,
			String mailadd, String postnum, String address0, String address1, String address2,
			String telnum) {
		//データベース接続(ログイン認証後のユーザ登録情報を変更する際にサンプル利用(登録情報確認の為))

	}

	public void Touroku(int id) {

	}

}
