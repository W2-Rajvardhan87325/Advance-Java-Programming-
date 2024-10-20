package com.Rajvardhan;

public class Book {
	public int bookId;
	public String bookName;
	public String bookAuthor;
	public String bookSubject;
	public double bookPrice;
	
	public Book() {
		
	}

	public Book(int bookId, String bookName, String bookAuthor, String bookSubject, double bookPrice) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookSubject = bookSubject;
		this.bookPrice = bookPrice;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public void setBookSubject(String bookSubject) {
		this.bookSubject = bookSubject;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public int getBookId() {
		return bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public String getBookSubject() {
		return bookSubject;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", bookSubject="
				+ bookSubject + ", bookPrice=" + bookPrice + "]";
	}
	
	
	
}
