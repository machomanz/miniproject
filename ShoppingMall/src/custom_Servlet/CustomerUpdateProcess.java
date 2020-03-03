package custom_Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import cust_DAO.UpdateCustomerDAO;
import cust_DTO.CustomerBean;



/**
 * Servlet implementation class CustomUpdateProcess
 */
@WebServlet("/update.do")

public class CustomerUpdateProcess extends HttpServlet {
	
	UpdateCustomerDAO dao = UpdateCustomerDAO.getInstance();
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");		
		
		CustomerBean bean = new CustomerBean();	
		bean.setCust_id(request.getParameter("cust_id").trim());
		bean.setCust_name(request.getParameter("cust_name").trim());
		bean.setCust_addr(request.getParameter("cust_addr").trim());
		bean.setCust_tel(request.getParameter("cust_tel").trim());
		
		int update = dao.customerUpdate(bean);
		System.out.println(bean+"\n"+update);
		
		String nextPage = "/";
		if(update != 1) {
			request.setAttribute("errorMsg", "업데이트가 실행되지 않았어. 다시 해봐");
			nextPage="/update.do?id="+request.getParameter("id");
		}				
		response.sendRedirect(nextPage);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");	
		HttpSession session = request.getSession(true);			
		session.getAttribute("customerList");
		System.out.println(session.getAttribute("customerList"));
//		CustomerBean bean = new CustomerBean(session.getAttribute("customerList"));	
		
		//session.setAttribute("customerList", customerList);
		session.setAttribute("errorMsg", request.getAttribute("errorMsg"));
		System.out.println();
		request.getRequestDispatcher("/update.jsp").forward(request, response);
	}
}
