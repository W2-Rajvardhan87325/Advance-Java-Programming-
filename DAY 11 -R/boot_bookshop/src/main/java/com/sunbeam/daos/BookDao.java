/**
 * Course: Mobile Computing (DMC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Oct 21, 2024
 */

package com.sunbeam.daos;

import java.util.List;

import com.sunbeam.entities.Book;

public interface BookDao {
	List<Book> findAll();
	List<Book> findBySubject(String subject);
	Book findById(int id);
	int save(Book b);
	int update(Book b);
	int deleteById(int id);
	List<String> findAllSubjects();
	int getBookCount();
}
