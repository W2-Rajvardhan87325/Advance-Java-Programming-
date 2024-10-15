package com.Rajvardhan.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Rajvardhan.dataaccess.BookDataAccess;
import com.Rajvardhan.entities.Book;

@WebServlet(value = "/showcart", loadOnStartup = 5)
@SuppressWarnings("serial")

public class ShowCartServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	// User Defined Service Method
	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		//HTML Head
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("    <meta charset=\"UTF-8\">");
		out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		out.println("    <title>SHOPPING CART</title>");
		out.println("</head>");
		
		//HTML Body
		out.println("<body>");
		out.println("<center><hr><h3>CART ITEMS</h3><hr></center>");
		out.println("<table border='0' cellpadding='10'>");
		out.println("<thead align='center'>" + "<th>NAME</th>" + "<th>AUTHOR</th>" + "<th>SUBJECT</th>"
				+ "<th>PRICE</th>" + "</thead>");
		
		//Accessing the values of the session from AddCartServlet.java
		HttpSession session = req.getSession();
		@SuppressWarnings("unchecked")
		List<Integer> items = (List<Integer>) session.getAttribute("items");
		
		//Printing the values of selected bookIds from the addcart.
		try (BookDataAccess obj = new BookDataAccess()) {
			for (Integer id : items) {
				Book b = obj.findById(id);
				out.println("<tr>");
				out.printf("<td>%s</td>", b.getBookName());
				out.printf("<td>%s</td>", b.getBookAuthor());
				out.printf("<td>%s</td>", b.getBookSubject());
				out.printf("<td>%f</td>", b.getBookPrice());
				out.println("</tr>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		//HTML Footer
		out.println("<tr>"
				+ "<td><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='/ServletProject/pages/Logout.html'><button>Log Out</button></a></p></td></tr>");
		out.println("<br>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

}
