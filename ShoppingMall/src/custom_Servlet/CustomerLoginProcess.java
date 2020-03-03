package custom_Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cust_DAO.LoginCustomerDAO;
import cust_DTO.CustomerBean;
import seller_DTO.SellerBean;

/**
 * Servlet implementation class CustomerLoginProcess
 */
@WebServlet("/login.do")
public class CustomerLoginProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LoginCustomerDAO dao = new LoginCustomerDAO();
		String cust_id = request.getParameter("cust_id").trim();
		String cust_pw = request.getParameter("cust_pw").trim();
		HttpSession session = request.getSession();
		
		/*
		 * if(!session.isNew()) { session.invalidate(); session =
		 * request.getSession(true); }
		 */
		
		SellerBean sellerBean = dao.sellerSearch(cust_id, cust_pw);
		CustomerBean customerBean = dao.nameSearch(cust_id, cust_pw);
		System.out.println(customerBean);
		
		if(cust_id.equals(sellerBean.getSell_id()) && cust_pw.equals(sellerBean.getSell_pw())) {
			session.setAttribute("sellerBean", sellerBean);
			request.getRequestDispatcher("/seller.jsp").forward(request, response);
			
		} else if(cust_id.equals(customerBean.getCust_id()) && cust_pw.equals(customerBean.getCust_pw())) {
			session.setAttribute("customerBean", customerBean);		
			request.getRequestDispatcher("/mainLogin.jsp").forward(request, response);
			
		}
		
	}

}
