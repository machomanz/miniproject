package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.ProductDAO;
import model.dto.SellerBean;

/**
 * Servlet implementation class ProductInsertProcessServlet
 */
@WebServlet("/productInsert.do")
public class ProductInsertProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF8");
		request.setCharacterEncoding("UTF8");

		String product_code = request.getParameter("product_code");
		String product_name = request.getParameter("product_name");
		System.out.println(product_code + product_name);
		int product_price = Integer.parseInt(request.getParameter("product_price").trim().intern());
		String category = request.getParameter("category");
		String product_img = request.getParameter("product_img");
		
		System.out.println(product_img);
		session = request.getSession();
		SellerBean sellerBean = (SellerBean) session.getAttribute("sellerBean");
		String sell_id = sellerBean.getSell_id();
		
		
		ProductDAO.getInstance().productInsert(product_price, product_code, product_name, category, sell_id, product_img);
		request.getRequestDispatcher("/seller.jsp").forward(request, response);
		
	}

}
