package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDAO;
import dao.LoginDAO;
import model.Account;
import model.LST;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//フォワード処理
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login/login.jsp");
		dispatcher.forward(request, response);

		/*	コメントアウト(自動挿入分)
		response.getWriter().append("Served at: ").append(request.getContextPath());
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//リクエストパラメータの文字コードを指定
		request.setCharacterEncoding("UTF-8");
		//do_post(request)処理
		String Userid = request.getParameter("USERID");
		String Pass = request.getParameter("PASS");
		LoginDAO loginDAO = new LoginDAO();
		//セッションスコープの準備(確認用)
		Account account = new Account();
		account.setId(Userid);
		account.setPass(Pass);
		//ログイン認証
		//ユーザアカウントの有無チェック(SQL)
		//フィールドの設置(LST型)
		int id = 0;
		boolean admin = false;
		String userid = Userid;
		String pass = Pass;
		//セッションスコープ(SQL抽出結果用:LST型)の準備
		LST list = new LST();
		if (loginDAO.ChkLogin(Userid) == true) {
			//ログイン認証
			//SQL抽出用メソッドの準備
			list = loginDAO.ChkLogin(id, admin, userid, pass);
			//HttpSessionインスタンスの取得
			HttpSession session1 = request.getSession();
			//セッションスコープにSQL抽出結果を格納
			session1.setAttribute("list", list);
			//ログイン実認証
			if (list == null) {
				//(NG)
				System.out.println("認証に失敗しました。再度ログインして下さい。");
				//フォワード処理(ログイン失敗)
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login/ng_Login.jsp");
				dispatcher.forward(request, response);
			} else {
				/*セッションスコープからadminフラグを取得
					LST L= list;*/
				//フラグ設定
				int f = 0;
				if (list.getPASS().equals(pass) == false) {
					f = 1;

				} else if (list.isADMIN() == false) {
					f = 2;

				} else if (list.isADMIN() == true) {
					f = 3;

				} else {

				}

				switch (f) {
				case 0:
				case 1:
					//NGの場合_パスワード比較
					System.out.println("パスワードが違います");

					//フォワード処理(ログイン失敗)
					RequestDispatcher dispatcher1 = request.getRequestDispatcher("/WEB-INF/login/ng_Login.jsp");
					dispatcher1.forward(request, response);
					break;
				case 2:
					//OKの場合_パスワード比較
					System.out.println("一般ログインに成功しました");
					AccountDAO dao = new AccountDAO();
					account = dao.findOne2(userid);
					HttpSession session0 = request.getSession();
					session0.setAttribute("account", account);
					//フォワード処理(成功…一般ユーザ)
					RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/login/ok_UserLogin.jsp");
					dispatcher2.forward(request, response);
					break;
				case 3:
					//OKの場合_パスワード比較
					System.out.println("管理者ログインに成功しました");
					//フォワード処理(成功…管理者ユーザ)
					RequestDispatcher dispatcher3 = request.getRequestDispatcher("/WEB-INF/login/ok_RootLogin.jsp");
					dispatcher3.forward(request, response);
					break;
				}
			}
		} else {
			System.out.println("ユーザが見つかりません。登録願います");
			//フォワード処理(失敗)
			RequestDispatcher dispatcher0 = request.getRequestDispatcher("/WEB-INF/login/ng_Login0.jsp");
			dispatcher0.forward(request, response);
		}
		/*	コメントアウト(自動挿入文)
		doGet(request, response);
		*/
	}

}
