/**
 * Course: Mobile Computing (DMC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Oct 22, 2024
 */

package com.sunbeam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.BookDao;
import com.sunbeam.entities.Book;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;
	@Override
	public List<String> getAllSubjects() {
		List<String> list = bookDao.findAllSubjects();
		return list;
	}
	@Override
	public List<Book> getBooksOfSubject(String subject) {
		List<Book> list = bookDao.findBySubject(subject);
		return list;
	}
	@Override
	public Book getBookById(int id) {
		Book book = bookDao.findById(id);
		return book;
	}
	@Override
	public List<Book> getAllBookList() {
		List<Book> list = bookDao.findAll();
		return list;
	}
	@Override
	public int updateBook(Book b) {
		int cnt = bookDao.update(b);
		return cnt;
	}
}
