/**
 * Course: Mobile Computing (DMC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Oct 22, 2024
 */

package com.sunbeam.services;

import java.util.List;

import com.sunbeam.entities.Book;

public interface BookService {
	List<String> getAllSubjects();
	List<Book> getBooksOfSubject(String subject);
	Book getBookById(int id);
	List<Book> getAllBookList();
	int updateBook(Book b);
}
