package com.Rajvardhan.beans;

import com.Rajvardhan.dataaccess.BookDataAccess;

public class DeleteBookBean {
	private String bookId;

	public DeleteBookBean() {
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public void deleteBook() {
		int id=Integer.parseInt(bookId);
		try(BookDataAccess obj=new BookDataAccess()){
			obj.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
