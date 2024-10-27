/**
 * Course: Mobile Computing (DMC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Oct 22, 2024
 */

package com.sunbeam.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sunbeam.entities.Book;
import com.sunbeam.services.BookService;

@Controller
public class BookshopControllerImpl {
	@Autowired
	private BookService bookService;
	/*
	@RequestMapping("/subjects")
	public String showSubjects(Model model) {
		List<String> list = bookService.getAllSubjects();
		model.addAttribute("subjectList", list);
			//internally does --> request.setAttribute("subjectList", list);
		return "subjects"; // prefix=/, suffix=.jsp, view=/ + subjects + .jsp
	}
	*/

	@RequestMapping("/subjects")
	public ModelAndView showSubjects() {
		List<String> list = bookService.getAllSubjects();
		ModelAndView mav = new ModelAndView("subjects", "subjectList", list);
		return mav;
	}
	
	@RequestMapping("/books")
	public String showBooks(@RequestParam("subject") String subject, Model model) {
		List<Book> list = bookService.getBooksOfSubject(subject);
		model.addAttribute("bookList", list);
		return "books"; // --> /books.jsp (view)
	}
	
	@RequestMapping("/addcart")
	public String addToCart(HttpSession session, 
			@RequestParam("book") String[] bookIds) {
		List<Book> cart = (List<Book>)session.getAttribute("cart");
		for (String bookId : bookIds) {
			int id = Integer.parseInt(bookId);
			Book b = bookService.getBookById(id);
			cart.add(b);
		}
		return "forward:subjects";
	}
	
	@RequestMapping("/showcart")
	public String showCart() {
		return "showcart"; // --> /showcart.jsp
	}
	
	@RequestMapping("/booklist")
	public String showBookList(Model model) {
		List<Book> list = bookService.getAllBookList();
		model.addAttribute("bookList", list);
		return "booklist"; // --> /booklist.jsp
	}
	
	//@RequestMapping(value="/editbook", method=RequestMethod.GET)
	@GetMapping("/editbook")
	public String editBook(@RequestParam("id") int id, Model model) {
		Book book = bookService.getBookById(id);
		model.addAttribute("bk", book);
		return "editbook"; // --> /editbook.jsp
	}
	
	@PostMapping("/editbook")
	public String updateBook(Book b) {
		System.out.println("In updateBook() -> " + b);
		int count = bookService.updateBook(b);
		return "redirect:booklist";
	}
}

