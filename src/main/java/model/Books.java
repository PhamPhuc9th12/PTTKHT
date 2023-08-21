package model;

public class Books {
	private int id;
	private String bookName;
	private String author;
	private int quantity;
	private int price;
	private String description;
	public Books() {
		super();
	}
	public Books(String bookName, String author, int quantity, int price, String description) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.quantity = quantity;
		this.price = price;
		this.description = description;
	}
	public Books(int id,String bookName, String author, int quantity, int price, String description) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.author = author;
		this.quantity = quantity;
		this.price = price;
		this.description = description;
	}
	public int setId(int id) {
		return this.id = id;
	}
	public int getId() {
		return id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Books [bookName=" + bookName + ", author=" + author + ", quantity=" + quantity + ", price=" + price
				+ ", description=" + description + "]";
	}
	
	
}
