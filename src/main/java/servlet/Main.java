package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDAO;
import dao.CartDAO;
import dao.ProductDAO;
import dao.SalesDAO;
import model.Account;
import model.Address;
import model.Cart;
import model.Product;
import model.Sales;
import model.SalesHistory;
import model.productInfo;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		//トップページから商品画像を押した時
		String id = request.getParameter("id");
		if (id != null) {
			ProductDAO dao = new ProductDAO();
			productInfo product = dao.findOne(Integer.parseInt(id));
			HttpSession session = request.getSession();
			session.setAttribute("product", product);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/item.jsp");
			rd.forward(request, response);
		}
		//購入履歴を見る時
		String account = request.getParameter("purchasehistory");//ログインしているユーザーIDが飛んでくる
		if (account != null) {
			SalesDAO dao = new SalesDAO();
			List<SalesHistory> list = dao.findAllHistory(account);
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/purchasehistory.jsp");
			rd.forward(request, response);
		}
		//カート内を見るとき
		String cart = request.getParameter("cart");//ログインしているユーザーIDが飛んでくる
		if (cart != null) {
			CartDAO dao = new CartDAO();
			List<Cart> list = dao.findAll(cart);
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/cart.jsp");
			rd.forward(request, response);
		}

		String para = request.getParameter("action");
		if (para != null && para.equals("login")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/login/login.jsp");
			rd.forward(request, response);
			//↓からハンバーガーメニュー
		} else if (para != null && para.equals("account")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/account.jsp");
			rd.forward(request, response);
		} else if (para != null && para.equals("logout")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/logout.jsp");
			rd.forward(request, response);
		} else if (para != null && para.equals("logout2")) {
			ProductDAO dao3 = new ProductDAO();
			List<Product> list = dao3.findAllback();
			request.setAttribute("list", list);
			HttpSession session = request.getSession();
			session.invalidate();
			System.out.println("セッション情報を破棄しました");
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		} else if (para != null && para.equals("new")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/login/new.jsp");
			rd.forward(request, response);
		} else if (para != null && para.equals("newok")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/login/newTourokuEnd.jsp");
			rd.forward(request, response);
		} else if (para != null && para.equals("completed")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/completion.jsp");
			rd.forward(request, response);
		} else if (para != null && para.equals("more")) {
			ProductDAO dao = new ProductDAO();
			List<Product> list = dao.find6();
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/more.jsp");
			rd.forward(request, response);
		} else if (para != null && para.equals("1")) {//1ページ選択
			//ページ切り替えます
			int num = Integer.parseInt(para);
			System.out.println(num);
			int num2 = (num - 1) * 6;
			System.out.println(num2);
			ProductDAO dao = new ProductDAO();
			List<Product> list = dao.find6Limit(num2);
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/more.jsp");
			rd.forward(request, response);
		} else if (para != null && para.equals("2")) {//2ページ選択
			//ページ切り替えます
			int num = Integer.parseInt(para);
			System.out.println(num);
			int num2 = (num - 1) * 6;
			System.out.println(num2);
			ProductDAO dao = new ProductDAO();
			List<Product> list = dao.find6Limit(num2);
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/more.jsp");
			rd.forward(request, response);
		} else if (para != null && para.equals("3")) {//3ページ選択
			//ページ切り替えます
			int num = Integer.parseInt(para);
			System.out.println(num);
			int num2 = (num - 1) * 6;
			System.out.println(num2);
			ProductDAO dao = new ProductDAO();
			List<Product> list = dao.find6Limit(num2);
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/more.jsp");
			rd.forward(request, response);
		} else {
			ProductDAO dao = new ProductDAO();
			List<Product> list = dao.findAllback();
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String para = request.getParameter("action");
		if (para != null && para.equals("new")) {
			String error = "";
			try {
				//文字エンコーディングの指定
				//				request.setCharacterEncoding("UTF-8");
				//DTOオブジェクト宣言
				Account account = new Account();
				//パラメーターの取得
				account.setId(request.getParameter("user_id"));
				account.setPass(request.getParameter("pass"));
				account.setEmail(request.getParameter("email"));
				account.setName1(request.getParameter("name1"));
				account.setName2(request.getParameter("name2"));
				account.setPostnum(Integer.parseInt(request.getParameter("postnum")));
				account.setAddress1(request.getParameter("address1"));
				account.setAddress2(request.getParameter("address2"));
				account.setAddress3(request.getParameter("address3"));
				account.setTelnum(Integer.parseInt(request.getParameter("tellnum")));
				//DAOオブジェクト宣言
				AccountDAO dao = new AccountDAO();
				dao.insertOne(account);
				System.out.println("登録完了");
				//１件登録メソッドを呼び出し
				response.sendRedirect("http://localhost:8080/Shop/Main?action=newok");
			} catch (IllegalStateException e) {
				error = "DB接続エラーの為、登録できませんでした";
			} catch (Exception e) {
				error = "予期せぬエラーが発生しました。<br> " + e;
			}
		} else if (para != null && para.equals("keyword")) {
			System.out.println("とりあえずpostで処理していくよ");
			String keyword = request.getParameter("keyword");
			System.out.println(keyword + "を取得しました");

			ProductDAO dao = new ProductDAO();
			System.out.println("データベースから検索します");
			List<Product> list = dao.search(keyword);

			request.setAttribute("list", list);
			request.setAttribute("keyword", keyword);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/search.jsp");
			rd.forward(request, response);
			//↓商品ページからカートに追加するボタンを押した時
		} else if (para != null && para.equals("regi")) {
			String quantity = request.getParameter("quantity");
			HttpSession session = request.getSession();
			session.setAttribute("quantity", quantity);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
			rd.forward(request, response);
			//↓セッションスコープにアカウントがない場合
		} else if (para != null && para.equals("regi2")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/login/login.jsp");
			rd.forward(request, response);
			//↓商品ページからカートに追加するボタンを押した時
		} else if (para != null && para.equals("cart")) {
			String user_id = request.getParameter("user_id");
			int product_code = Integer.parseInt(request.getParameter("product_code"));
			//日付
			long miliseconds = System.currentTimeMillis();
			Date date = new Date(miliseconds);
			CartDAO dao = new CartDAO();
			dao.insertOne(new Cart(user_id, product_code, date));
			System.out.println("インサートしてきたよ");
			response.sendRedirect("http://localhost:8080/Shop/Main");
		} else if (para != null && para.equals("confirm")) {
			Address address = new Address();
			address.setDelivery_date(request.getParameter("delivery_date"));
			address.setAddress1(request.getParameter("address1"));
			address.setAddress2(request.getParameter("address2"));
			address.setAddress3(request.getParameter("address3"));
			address.setAddress4(request.getParameter("address4"));
			HttpSession session = request.getSession();
			session.setAttribute("address", address);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/confirm.jsp");
			rd.forward(request, response);
		} else if (para != null && para.equals("complete")) {
			String id = request.getParameter("id");
			Date delivery_date = Date.valueOf(request.getParameter("delivery_date"));
			String address1 = request.getParameter("address1");
			String address2 = request.getParameter("address2");
			String address3 = request.getParameter("address3");
			String address4 = request.getParameter("address4");
			int product_code = Integer.parseInt(request.getParameter("product_code"));
			int product_price = Integer.parseInt(request.getParameter("product_price"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));

			Sales sales = new Sales(id, delivery_date, address1, address2, address3, address4, product_code,
					product_price, quantity);
			SalesDAO dao = new SalesDAO();
			dao.insertOne(sales);
			System.out.println("登録完了");

			response.sendRedirect("http://localhost:8080/Shop/Main?action=completed");

			//アカウント情報変更画面
		} else if (para != null && para.equals("account_update")) {
			String user_id = request.getParameter("user_id");
			String email = request.getParameter("email");
			int telnum = Integer.parseInt(request.getParameter("telnum"));
			String address1 = request.getParameter("address1");
			String address2 = request.getParameter("address2");
			String address3 = request.getParameter("address3");
			String address4 = request.getParameter("address4");
			AccountDAO dao = new AccountDAO();
			dao.updateOne(new Account(user_id, email, telnum, address1, address2, address3, address4));
			System.out.println("アップデートしてきたよ");

			//セッションスコープにアカウント情報再格納
			System.out.println("セッションスコープにアカウント情報を再格納");
			Account account = dao.findOne2(user_id);
			HttpSession session = request.getSession();
			session.setAttribute("account", account);

			//ホーム画面に返ります
			ProductDAO dao2 = new ProductDAO();
			List<Product> list = dao2.findAllback();
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);

		} else {
			//ログイン処理
			String id = request.getParameter("id");
			String pass = request.getParameter("pass");
			//データベース行きます
			AccountDAO dao = new AccountDAO();
			Account account = dao.findOne(id, pass);
			if (account == null) {
				//リクエストスコープにエラーメッセージ格納
				request.setAttribute("errorMsg", "アカウントが見つかりませんでした");
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
			} else if (account.getAdmin()) {
				//フォワード
				ProductDAO dao2 = new ProductDAO();
				List<Product> list = dao2.findAll();
				request.setAttribute("list", list);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/main.jsp");
				rd.forward(request, response);
			} else {
				//セッションスコープにアカウント情報格納
				System.out.println("セッションスコープにアカウント情報を格納");
				AccountDAO dao2 = new AccountDAO();
				account = dao.findOne2(id);
				HttpSession session = request.getSession();
				session.setAttribute("account", account);
				//フォワード
				ProductDAO dao3 = new ProductDAO();
				List<Product> list = dao3.findAllback();
				request.setAttribute("list", list);
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
			}
		}

	}

}
