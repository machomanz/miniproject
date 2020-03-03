package custom_Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cust_DAO.AddCustomerDAO;
import cust_DTO.CustomerBean;


/**
 * Servlet implementation class CustomerAddProcess
 */

@WebServlet("/signUp.do")
public class CustomerAddProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
			
		CustomerBean bean = new CustomerBean();		
		bean.setCust_id(request.getParameter("cust_id"));
		bean.setCust_pw(request.getParameter("cust_pw"));
		bean.setCust_name(request.getParameter("cust_name"));
		bean.setCust_addr(request.getParameter("cust_addr"));
		bean.setCust_tel(request.getParameter("cust_tel"));
				
		request.setAttribute("bean", AddCustomerDAO.getInstance().insertCustomer(bean));
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		
	}

}
