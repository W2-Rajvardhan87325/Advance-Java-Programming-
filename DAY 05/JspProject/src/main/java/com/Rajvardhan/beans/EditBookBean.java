package com.Rajvardhan.beans;

import com.Rajvardhan.dataaccess.BookDataAccess;
import com.Rajvardhan.entities.Book;

public class EditBookBean {
	private String bookId;
	private Book bk;
	private Book upbk;

	private String id;
	private String name;
	private String author;
	private String subject;
	private String price;

	public EditBookBean() {
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public Book getBk() {
		return bk;
	}

	public void setBk(Book bk) {
		this.bk = bk;
	}

	// =============================================================

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	public String getSubject() {
		return subject;
	}

	public String getPrice() {
		return price;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Book getUpbk() {
		return upbk;
	}

	public void setUpbk(Book upbk) {
		this.upbk = upbk;
	}

	public void updateBook() {
		double changePrice = Double.parseDouble(price);
		upbk = new Book(0, id, author, subject, changePrice);
		try (BookDataAccess obj = new BookDataAccess()) {
			obj.update(upbk);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void displayBook() {
		int id = Integer.parseInt(bookId);
		try (BookDataAccess obj = new BookDataAccess()) {
			bk = obj.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
