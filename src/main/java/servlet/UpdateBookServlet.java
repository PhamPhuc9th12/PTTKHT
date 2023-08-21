package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectDB.SQLConnect;
import dao.BookDao;
import model.Books;

/**
 * Servlet implementation class UpdateBookServlet
 */
@WebServlet("/update-book")
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idBook = Integer.valueOf(request.getParameter("idBook"));
		request.setAttribute("idBook", idBook);
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
				int bId = Integer.valueOf(request.getParameter("bID"));
				String bName = request.getParameter("bName");
				String bAuthor = request.getParameter("bAuthor");
				int bQuantity = Integer.valueOf(request.getParameter("bQuantity"));
				int bPrice = Integer.valueOf(request.getParameter("bPrice"));
				String bDescription = request.getParameter("bDescription");
				Books updateBook = new Books(bId,bName, bAuthor, bQuantity, bPrice, bDescription);
				BookDao bDao = new BookDao(SQLConnect.getConnection());
				bDao.updateBook(updateBook);
				request.getRequestDispatcher("get-allbook").forward(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
	}

}
