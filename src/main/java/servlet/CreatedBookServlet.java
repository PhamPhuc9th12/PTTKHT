package servlet;

import java.awt.print.Book;
import model.Books;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectDB.SQLConnect;
import dao.BookDao;

/**
 * Servlet implementation class CreatedBookServlet
 */
@WebServlet("/created-book")
public class CreatedBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int result = 0;
			String bookName = request.getParameter("bookName");
			String author = request.getParameter("author");
			int quantity = Integer.valueOf(request.getParameter("quantity"));
			int price = Integer.valueOf(request.getParameter("price"));
			String description = request.getParameter("description");
			Books book = new Books(bookName,author,quantity,price,description);
			try {
				BookDao bookDao = new BookDao(SQLConnect.getConnection());
				result = bookDao.createBook(book);
				if(result > 0) {
					request.getRequestDispatcher("get-allbook").forward(request, response);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
	}

}
