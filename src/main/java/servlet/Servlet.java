package servlet;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.entryLogic;
import model.productInfo;
import model.updateLogic;
/**
 * Servlet implementation class storesServlet
 */
@WebServlet("/Servlet")
@MultipartConfig
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if(action.equals("mente")) {
			//商品メンテナンスメニュー画面へフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/admin/mente.jsp");
			dispatcher.forward(request, response);

		}else if(action.equals("entry")) {
			//商品登録にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/admin/entry.jsp");
			dispatcher.forward(request, response);

		}else if(action.equals("update")){

			String pagi = request.getParameter("pagi");

			updateLogic updateLogic = new updateLogic();
			List<productInfo>ShohinList = updateLogic.update();

			HttpSession session = request.getSession();
			session.setAttribute("ShohinList",ShohinList);
			request.setAttribute("pagi",pagi);

			//商品情報変更にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/admin/update.jsp");
			dispatcher.forward(request, response);

		}else if(action.equals("updateInput")) {
			String line = request.getParameter("line");
			request.setAttribute("line",line);

			//商品変更情報入力へフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/admin/updateInput.jsp");
			dispatcher.forward(request, response);

		}else if(action.equals("delete")){
			//商品削除にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/admin/delete.jsp");
			dispatcher.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");

		if(action.equals("entryEnd")) {
			String productName = request.getParameter("productName");
			String cateCode = request.getParameter("cateCode");
			String size = request.getParameter("size");
			String productDetails = request.getParameter("productDetails");
			int price = Integer.parseInt(request.getParameter("price"));
			int stock = Integer.parseInt(request.getParameter("stock"));

			Part part = request.getPart("imagesPass");
			String imagesPass = Paths.get(part.getSubmittedFileName()).getFileName().toString();
			String path = getServletContext().getRealPath("/upload");
			System.out.println(path);
			part.write(path+File.separator+imagesPass);
			Part part2 = request.getPart("imagesPass2");
			String imagesPass2 = Paths.get(part2.getSubmittedFileName()).getFileName().toString();
			String path2 = getServletContext().getRealPath("/upload");
			part2.write(path2+File.separator+imagesPass2);
			Part part3 = request.getPart("imagesPass3");
			String imagesPass3 = Paths.get(part3.getSubmittedFileName()).getFileName().toString();
			String path3 = getServletContext().getRealPath("/upload");
			part3.write(path3+File.separator+imagesPass3);
//			String imagesPass = request.getParameter("imagesPass");//pが小文字になってた
//			String imagesPass2 = request.getParameter("imagesPass2");
//			String imagesPass3 = request.getParameter("imagesPass3");

			//インスタンスを作成
			productInfo productinfo= new productInfo(productName,cateCode,size,productDetails,price,stock,imagesPass,imagesPass2,imagesPass3);
			entryLogic dao = new entryLogic();
			boolean shingi =dao.execute(productinfo);
			//リクエストスコープに保存
			request.setAttribute("productinfo",productinfo);

			//商品登録完了へフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/admin/entryEnd.jsp");
			dispatcher.forward(request, response);


		}else if(action.equals("updateEnd")) {

			int productCode = Integer.parseInt(request.getParameter("productCode"));
			String productName = request.getParameter("productName");
			String productDetails = request.getParameter("productDetails");
			int price = Integer.parseInt(request.getParameter("price"));
			int stock = Integer.parseInt(request.getParameter("stock"));


			//インスタンスを作成
			productInfo productinfo2= new productInfo(productCode,productName,productDetails,price,stock);
			updateLogic dao = new updateLogic();

			boolean shingi =dao.execute(productinfo2);
			//リクエストスコープに保存
			request.setAttribute("productinfo2",productinfo2);

			//商品情報変更完了へフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/admin/updateEnd.jsp");
			dispatcher.forward(request, response);

		}

	}

}
