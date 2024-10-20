package com.Rajvardhan.servlets;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Rajvardhan.dataaccess.BookDataAccess;
import com.Rajvardhan.entities.Book;

@SuppressWarnings("serial")
@WebServlet(value = "/addbook")

public class AddBookServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// Content Type HTML
		resp.setContentType("text/html");
		
		// Fetching the data from Addbook.html
		String name = req.getParameter("name");
		String author = req.getParameter("author");
		String subject = req.getParameter("subject");
		double price = Double.parseDouble(req.getParameter("price"));

		//Object to store the fetched data.
		Book b = new Book(0, name, author, subject, price);

		try (BookDataAccess obj = new BookDataAccess()) {
			//Saving the data in the DB using save() method
			int count = obj.save(b);
			
			//On Successful insertion redirect to BookListServlet.java
			if (count == 1) {
				RequestDispatcher rd = req.getRequestDispatcher("booklist");
				rd.forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException();
		}

	}

}
