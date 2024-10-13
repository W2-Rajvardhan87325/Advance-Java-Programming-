package com.Rajvardhan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDataAccess implements AutoCloseable {
	private Connection con;

	public BookDataAccess() throws Exception {
		con = MysqlConnection.getConnection();
	}

	@Override
	public void close() throws Exception {
		con.close();
	}

	public int save(Book b) throws Exception {
		String sql = "INSERT INTO books values(default,?,?,?,?)";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, b.getBookName());
			stmt.setString(2, b.getBookAuthor());
			stmt.setString(3, b.getBookSubject());
			stmt.setDouble(4, b.getBookPrice());
			int count = stmt.executeUpdate();
			return count;
		}
	}

	public int update(Book b) throws Exception {
		String sql = "UPDATE books SET name=?, author=?, subject=?, price=? WHERE id=?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, b.getBookName());
			stmt.setString(2, b.getBookAuthor());
			stmt.setString(3, b.getBookSubject());
			stmt.setDouble(4, b.getBookPrice());
			stmt.setInt(5, b.getBookId());
			int count = stmt.executeUpdate();
			return count;
		}
	}

	public int deleteById(int id) throws Exception {
		String sql = "DELETE FROM books WHERE id=?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			int count = stmt.executeUpdate();
			return count;
		}
	}

	public List<Book> findAll() throws Exception {
		List<Book> list = new ArrayList<Book>();
		String sql = "SELECT * FROM books";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String author = rs.getString("author");
					String subject = rs.getString("subject");
					double price = rs.getDouble("price");
					Book b = new Book(id, name, author, subject, price);
					list.add(b);
				}
			}
		}
		return list;
	}

	public Book findById(int id) throws Exception {
		Book obj=new Book();
		String sql = "SELECT * FROM books WHERE id=?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery()) {
					if(rs.next()) {
					id = rs.getInt("id");
					String name = rs.getString("name");
					String author = rs.getString("author");
					String subject = rs.getString("subject");
					double price = rs.getDouble("price");

					obj = new Book(id, name, author, subject, price);
				}
			}
		}
		return obj;
	}

	public List<Book> findBySubject(String subject) throws Exception {
		List<Book> list = new ArrayList<>();
		String sql = "SELECT * FROM books WHERE subject=?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, subject);
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String author = rs.getString("author");
					subject = rs.getString("subject");
					double price = rs.getDouble("price");
					
					Book obj = new Book(id, name, author, subject, price);
					list.add(obj);		
				}
			}
		}
		return list;
	}

	public List<String> findAllSubjects() throws Exception {
		List<String> store = new ArrayList<>();
		String sql = "SELECT DISTINCT subject FROM books";
		try (PreparedStatement stm = con.prepareStatement(sql)) {
			try (ResultSet rs = stm.executeQuery()) {
				while (rs.next()) {
					String dbSubject = rs.getString("subject");
					store.add(dbSubject);
				}
			}
		}
		return store;
	}

}
