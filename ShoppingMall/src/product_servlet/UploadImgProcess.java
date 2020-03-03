package product_servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class UploadImgProcess
 */
@WebServlet("/upload.do")
public class UploadImgProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getSession().getServletContext().getRealPath("imgFolder");
		int size = 1024 * 1024 * 10;
		String file = "";
		String originalFile = "";
		
		try {
			MultipartRequest multi = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());
			
			Enumeration files = multi.getFileNames();
			String str = (String) files.nextElement();
			
			file = multi.getFilesystemName(str);
			originalFile = multi.getOriginalFileName(str);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/productDetailInsert.jsp").forward(request, response);
	}

}
