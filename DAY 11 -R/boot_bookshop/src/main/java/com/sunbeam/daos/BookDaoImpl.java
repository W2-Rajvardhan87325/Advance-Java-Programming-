/**
 * Course: Mobile Computing (DMC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Oct 21, 2024
 */

package com.sunbeam.daos;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sunbeam.entities.Book;

@Repository
public class BookDaoImpl implements BookDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private BookRowMapper bookRowMapper;

	@Override
	public List<Book> findAll() {
		String sql = "SELECT * FROM books";
		List<Book> list = jdbcTemplate.query(sql, bookRowMapper);
		return list;
	}

	@Override
	public List<Book> findBySubject(String subject) {
		String sql = "SELECT * FROM books WHERE subject = ?";
		List<Book> list = jdbcTemplate.query(sql, bookRowMapper, subject);
		return list;
	}

	@Override
	public Book findById(int id) {
		/*
		String sql = "SELECT * FROM books WHERE id = ?";
		List<Book> list = jdbcTemplate.query(sql, bookRowMapper, id);
		return list.isEmpty() ? null : list.get(0);
		*/
		String sql = "SELECT * FROM books WHERE id = ?";
		Book book = jdbcTemplate.queryForObject(sql, bookRowMapper, id);
		return book;
	}

	@Override
	public int save(Book b) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Book b) {
		String sql = "UPDATE books SET name=?, author=?, subject=?, price=? WHERE id=?";
		int count = jdbcTemplate.update(sql, b.getName(), b.getAuthor(), b.getSubject(), b.getPrice(), b.getId());
		return count;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<String> findAllSubjects() {
		/*
		List<Book> bookList = findAll();
		Stream<String> subjectStream = bookList.stream().map(b -> b.getSubject()).distinct();
		List<String> list = subjectStream.collect(Collectors.toList());
		return list;
		*/
		String sql = "SELECT DISTINCT subject FROM books";
		List<String> list = jdbcTemplate.queryForList(sql, String.class);
		return list;
	}

	@Override
	public int getBookCount() {
		String sql = "SELECT COUNT(*) cnt FROM books";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
	}
}
