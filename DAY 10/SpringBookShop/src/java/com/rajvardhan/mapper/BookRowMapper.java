package com.rajvardhan.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.rajvardhan.entities.Book;

@Component
public class BookRowMapper implements RowMapper<Book> {
	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		int id = rs.getInt("id");
		String name = rs.getString("name");
		String author = rs.getString("author");
		String subject = rs.getString("subject");
		double price = rs.getDouble("price");
		Book b = new Book(id, name, author, subject, price);
		return b;
	}
}
