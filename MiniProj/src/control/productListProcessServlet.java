package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.ProductDAO;
import model.dto.ProductBean;

/**
 * Servlet implementation class productListProcessServlet
 */
@WebServlet("/productList.do")
public class productListProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<ProductBean> productList = new ArrayList<ProductBean>();
	private HttpSession session;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		productList = ProductDAO.getInstance().productList();
		session = request.getSession();
		System.out.println(productList);
		
		if(!session.isNew()) {
			session.invalidate();
			session = request.getSession(true);
		}
		
		session.setAttribute("productList", productList);
		request.getRequestDispatcher("productList.jsp").forward(request, response);
	}

}
