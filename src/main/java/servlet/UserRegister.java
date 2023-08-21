package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectDB.SQLConnect;
import dao.UserDao;
import model.User;

@WebServlet("/user-register")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		// cho add dữ liệu dạng tiếng việt vào db
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("uName");
		String email = request.getParameter("uEmail");
		String password = request.getParameter("uPass");
		User newUser = new User( name, email, password);
		try {
			UserDao uDao = new UserDao(SQLConnect.getConnection());
			int result = uDao.createUser(newUser);
			if(result > 0) {
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
