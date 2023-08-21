package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connectDB.SQLConnect;
import dao.UserDao;
import model.User;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter()) {
			String nameUser = request.getParameter("uEmail");
			String passUser = request.getParameter("uPassWord");
			UserDao userDao = new UserDao(SQLConnect.getConnection());
			User userCreated = userDao.loginUser(nameUser, passUser);
			if(userCreated != null) {
				HttpSession session = request.getSession();
				session.setAttribute("acc", userCreated);
				request.getRequestDispatcher("get-allbook").forward(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
