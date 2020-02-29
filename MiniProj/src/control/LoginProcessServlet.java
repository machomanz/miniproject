package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.CustomerDAO;
import model.dao.SellerDAO;
import model.dto.CustomerBean;
import model.dto.SellerBean;

/**
 * Servlet implementation class LoginProcessServlet
 */
@WebServlet("/login.do")
public class LoginProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	private SellerBean sellerBean;
	private CustomerBean customerBean;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		sellerBean = SellerDAO.getInstance().sellerSearch(id, pw);
		customerBean = CustomerDAO.getInstance().customerSearch(id, pw);
		
		if(id.equals(sellerBean.getSell_id()) && pw.equals(sellerBean.getSell_pw())) {
			session = request.getSession();
			
			if(!session.isNew()) {
				session.invalidate();
				session = request.getSession(true);
			}
			
			session.setAttribute("sellerBean", sellerBean);
			request.getRequestDispatcher("/seller.jsp").forward(request, response);
		} else if(id.equals(customerBean.getCust_id()) && pw.equals(customerBean.getCust_pw())) {
			session = request.getSession();
			
			if(!session.isNew()) {
				session.invalidate();
				session = request.getSession(true);
			}
			
			session.setAttribute("customerBean", customerBean);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} else {
			response.sendRedirect("/login.jsp");
		}
		
		
	}

}
