package com.Rajvardhan.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Rajvardhan.dataaccess.BookDataAccess;

@SuppressWarnings("serial")
@WebServlet(value = "/delbook")

public class DeleteBookServlet extends HttpServlet {
	//Only revoked using the getReq only so no doPost code.
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Fetching the bookId from the BooklistServlet.java (In the From of Query-String)
		String bookId = req.getParameter("bookId");
		int id = Integer.parseInt(bookId);
		
		//Trying to delete the book by using bookId from the DB.
		try (BookDataAccess obj = new BookDataAccess()) {
			int count = obj.deleteById(id);
			
			//If book is deleted the message is passed to the BooklistServlet.java in the from of req-setAttribute.
			String message = "BOOK DELETED :: " + count;
			req.setAttribute("msg", message);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		//Redirecting to BooklistServlet.java.
		RequestDispatcher rd = req.getRequestDispatcher("booklist");
		rd.forward(req, resp);
	}
}
