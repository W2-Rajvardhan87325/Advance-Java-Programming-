package com.Rajvardhan.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Rajvardhan.dataaccess.BookDataAccess;
import com.Rajvardhan.entities.Book;

@SuppressWarnings("serial")
@WebServlet(value = "/books", loadOnStartup = 4)
public class BooksServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("subject");
		if (name == null) {
			resp.sendRedirect("/ServletProject/pages/SubjectFailed.html");
		}

		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("    <meta charset=\"UTF-8\">");
		out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		out.println("    <title>Book Page</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<center><hr><h3>DISPLAYLING BOOKS</h3><hr></center>");
		out.println("<form action='addtocart' method='POST'>");
		out.println("<table border='0' cellpadding='10'>");
		out.println("<thead align='center'>" + "<th>SELECT</th>" + "<th>NAME</th>" + "<th>AUTHOR</th>"
				+ "<th>SUBJECT</th>" + "<th>PRICE</th>" + "</thead>");
		try (BookDataAccess obj = new BookDataAccess()) {
			List<Book> bk = obj.findBySubject(name);
			for (Book book : bk) {
				out.println("<tr>");
				out.printf("<td align='center'><input type='checkbox' name='bookName' value='%d'></td>",
						book.getBookId());
				out.printf("<td>%s</td>", book.getBookName());
				out.printf("<td>%s</td>", book.getBookAuthor());
				out.printf("<td align='center'>%s</td>", book.getBookSubject());
				out.printf("<td align='center'>%s</td>", book.getBookPrice());
				out.println("</tr>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException();
		}
		out.println("<br>");
		out.println("<tr>");
		out.println("<td><input type='submit' value='Add to Cart'></td>");
		out.println("</tr>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
}
