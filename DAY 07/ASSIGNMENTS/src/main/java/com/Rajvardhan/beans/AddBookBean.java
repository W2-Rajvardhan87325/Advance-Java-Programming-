package com.Rajvardhan.beans;

import com.Rajvardhan.dataaccess.BookDataAccess;
import com.Rajvardhan.entities.Book;

public class AddBookBean {

	private String name;
	private String author;
	private String subject;
	private String price;

	public AddBookBean() {
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

	public void addBooks() {
		double changePrice = Double.parseDouble(price);
		Book bk = new Book(0, name, author, subject, changePrice);
		try (BookDataAccess obj = new BookDataAccess()) {
			obj.save(bk);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
