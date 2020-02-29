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

import model.dao.CustomerDAO;
import model.dto.CustomerBean;

/**
 * Servlet implementation class CustomerListProcessServlet
 */
@WebServlet("/customerList.do")
public class CustomerListProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<CustomerBean> customerList = new ArrayList<CustomerBean>();
	private HttpSession session;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		customerList = CustomerDAO.getInstance().customerList();
		session = request.getSession();
		if(!session.isNew()) {
			session.invalidate();
			session = request.getSession(true);
		}
		
		session.setAttribute("customerList", customerList);
		request.getRequestDispatcher("/customerList.jsp").forward(request, response);
	}

}
