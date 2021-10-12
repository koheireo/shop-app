package servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.ProductDAO;
import model.Product;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/Admin")
@MultipartConfig
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductDAO dao=new ProductDAO();
		List<Product> list=dao.findAll();
		request.setAttribute("list", list);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/admin/main.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("こっちきたよ");
		request.setCharacterEncoding("utf-8");
		int category_code = Integer.parseInt(request.getParameter("category_code"));
		String name=request.getParameter("name");
		String size=request.getParameter("size");
		int price=Integer.parseInt(request.getParameter("price"));
		int stock=Integer.parseInt(request.getParameter("stock"));
		String details=request.getParameter("details");
		//日付
		long miliseconds = System.currentTimeMillis();
        Date date = new Date(miliseconds);
        //ファイル
		Part part=request.getPart("images_pass");
		String images_pass=Paths.get(part.getSubmittedFileName()).getFileName().toString();
		String path=getServletContext().getRealPath("/upload");
		System.out.println(path);
		part.write(path+File.separator+images_pass);
		ProductDAO dao=new ProductDAO();
		dao.insertOne(new Product(category_code, name, size, price, stock, details, date, images_pass));
		response.sendRedirect("http://localhost:8080/Shop/Admin");
	}

}
