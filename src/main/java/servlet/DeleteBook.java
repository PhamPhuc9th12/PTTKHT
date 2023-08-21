package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectDB.SQLConnect;
import dao.BookDao;

/**
 * Servlet implementation class DeleteBook
 */
@WebServlet("/delete-book")
public class DeleteBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int idBook = Integer.valueOf(request.getParameter("idBook"));
			BookDao bookDao = new BookDao(SQLConnect.getConnection());
			bookDao.deleteBook(idBook);
			response.sendRedirect("get-allbook");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	

}
