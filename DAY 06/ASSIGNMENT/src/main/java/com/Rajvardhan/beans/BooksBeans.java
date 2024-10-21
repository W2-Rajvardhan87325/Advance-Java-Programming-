package com.Rajvardhan.beans;

import java.util.ArrayList;
import java.util.List;

import com.Rajvardhan.dataaccess.BookDataAccess;
import com.Rajvardhan.entities.Book;

public class BooksBeans {
	private String subject;
	private List<Book> books;
	
	public BooksBeans() {
		this.books = new ArrayList<Book>();
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public boolean fetchBooks() {
		try(BookDataAccess bookDao = new BookDataAccess()) {
			this.books = bookDao.findBySubject(this.subject);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
