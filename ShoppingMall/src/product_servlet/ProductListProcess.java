package product_servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import product_DAO.ProductDAO;
import product_DTO.ProductBean;

/**
 * Servlet implementation class ProductListProcess
 */
@WebServlet("/productList.do")
public class ProductListProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ProductDAO productDAO = ProductDAO.getInstance();
		List<ProductBean> productList = productDAO.productList();
		
		session.setAttribute("productList", productList);
		request.getRequestDispatcher("/productList.jsp").forward(request, response);
	}

}
