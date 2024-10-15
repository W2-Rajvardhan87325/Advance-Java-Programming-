package com.Rajvardhan.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/addtocart")
@SuppressWarnings("serial")

public class AddCartServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Collecting the multiple selection of the Book-names from BooksServlet.java in String array.
		String[] bookIds = req.getParameterValues("bookName");

		//If the String array is null or 0 the Redirect to the SubjectFailed.html.
		if (bookIds == null || bookIds.length == 0) {
			resp.sendRedirect("/ServletProject/pages/SubjectFailed.html");
		} 
		else {
			
			//Using the Empty Session which is created at the LoginServlet Page to store Book ID.
			HttpSession session = req.getSession();	
			@SuppressWarnings("unchecked")
			List<Integer> items = (List<Integer>) session.getAttribute("items");
			
			//Converting the values from String -> Integer one by one.
			for (String book : bookIds) {
				int id = Integer.parseInt(book);
				items.add(id);
			}
			
			//Redirection to SubjectServlet.java 
			//(After adding the books to cart then to subject page to view the cart or add new subjects)
			resp.sendRedirect("Subjects");
		}

	}

}
