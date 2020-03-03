package custom_Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cust_DAO.SearchCustomerDAO;


/**
 * Servlet implementation class CustomerSearchProcess
 */
@WebServlet("/example.do")
public class CustomerSearchProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
		
		request.setAttribute("customerList", SearchCustomerDAO.getInstance().customerList());		
		request.getRequestDispatcher("/example.jsp").forward(request, response);
	}

}
