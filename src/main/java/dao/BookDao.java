package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Books;

public class BookDao {
	private String query;
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection con;
	
	public BookDao(Connection con) {
		this.con = con;
	}
	
	public int createBook(Books book) {
		int result = 0;
		try {
			query = "insert into books (book_name,author,quantity,price,description) values (?,?,?,?,?)";
			ps = this.con.prepareStatement(query);
			ps.setString(1, book.getBookName());
			ps.setString(2, book.getAuthor());
			ps.setInt(3, book.getQuantity());
			ps.setInt(4, book.getPrice());
			ps.setString(5, book.getDescription());
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public List<Books> getAllBook(){
		List<Books> listBooks = new ArrayList<>();
		try {
			query = "select * from books";
			ps = this.con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				Books book = new Books();
				book.setId(rs.getInt("id"));
				book.setBookName(rs.getString("book_name"));
				book.setAuthor(rs.getString("author"));
				book.setQuantity(rs.getInt("quantity"));
				book.setPrice(rs.getInt("price"));
				book.setDescription(rs.getString("description"));
				listBooks.add(book);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listBooks;
	}
	public Books getSingleBook(int id) {
		query = "select * from books where id = ?";
		Books book = new Books();
		try {
			ps = this.con.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				book.setId(rs.getInt("id"));
				book.setBookName(rs.getString("book_name"));
				book.setAuthor(rs.getString("author"));
				book.setQuantity(rs.getInt("quantity"));
				book.setPrice(rs.getInt("price"));
				book.setDescription(rs.getString("description"));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	public void updateBook(Books book) {
		query = "update books set book_name = ?,author = ?,quantity = ?,price = ?,description = ? where id =?";
		try {
			ps = this.con.prepareStatement(query);
			ps.setString(1, book.getBookName());
			ps.setString(2, book.getAuthor());
			ps.setInt(3, book.getQuantity());
			ps.setInt(4, book.getPrice());
			ps.setString(5, book.getDescription());
			ps.setInt(6, book.getId());
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteBook(int idBook) {
		query = "delete from books where id = ?";
		try {
			ps = this.con.prepareStatement(query);
			ps.setInt(1, idBook);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
