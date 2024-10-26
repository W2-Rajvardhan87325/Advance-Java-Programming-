package com.rajvardhan.daos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rajvardhan.contracts.BookDaoable;
import com.rajvardhan.entities.Book;
import com.rajvardhan.mapper.BookRowMapper;

@Repository
public class BookDataAccess implements BookDaoable {
	@Autowired
	private JdbcTemplate jdbcTemp;
	@Autowired
	private BookRowMapper bkrowmap;

	@Override
	public int save(Book bk) {
		String sql = "INSERT INTO books values(default,?,?,?,?)";
		int count = jdbcTemp.update(sql, bk.getBookName(), bk.getBookAuthor(), bk.getBookSubject(), bk.getBookPrice());
		return count;
	}

	@Override
	public int update(Book bk) {
		String sql = "UPDATE books SET name=?, author=?, subject=?, price=? WHERE id=?";
		int count = jdbcTemp.update(sql, bk.getBookName(), bk.getBookAuthor(), bk.getBookSubject(), bk.getBookPrice(),
				bk.getBookId());
		return count;
	}

	@Override
	public List<Book> findAll() {
		List<Book> list = new ArrayList<Book>();
		String sql = "SELECT * FROM books";
		list = jdbcTemp.query(sql, bkrowmap);
		return list;
	}

	@Override
	public int deleteById(int id) {
		String sql = "DELETE FROM books WHERE id=?";
		int count = jdbcTemp.update(sql, id);
		return count;
	}

	@Override
	public Book findById(int id) {
		String sql = "SELECT * FROM books WHERE id=?";
		Book book = jdbcTemp.queryForObject(sql, bkrowmap, id);
		return book;
	}

	@Override
	public List<Book> findBySubject(String subject) {
		List<Book> list = new ArrayList<>();
		String sql = "SELECT * FROM books WHERE subject=?";
		list = jdbcTemp.query(sql,bkrowmap,subject);
		return list;
	}

	@Override
	public List<String> findAllSubjects() {
		List<String> list = new ArrayList<>();
		String sql = "SELECT DISTINCT subject FROM books";
		list = jdbcTemp.queryForList(sql, String.class);
		return list;
	}
}
