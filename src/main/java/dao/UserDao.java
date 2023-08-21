package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String query;
	
	public UserDao(Connection con) {
		this.con = con;
	}
	public int createUser(User user) {
		
		int result = 0;
		try {
			query = "insert into user (name,password,email) values(?,?,?)";
			ps = this.con.prepareStatement(query);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			result = ps.executeUpdate();
			if(result > 0) {
				System.out.println("DOne");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	public User loginUser (String email, String pass) throws SQLException {
		User users = null;
		query = "select * from user where email = ? and password = ?";
		ps = this.con.prepareStatement(query);
		ps.setString(1, email);
		ps.setString(2, pass);
		rs = ps.executeQuery();
		if(rs.next()) {
			users = new User();
			users.setEmail(rs.getString("email"));
			users.setPassword(rs.getString("password"));
		}
		return users;
	}
}
