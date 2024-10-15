package com.Rajvardhan;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Books Table</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<hr>");
		out.println("<h1><center>SERVLET WITH JDBC<center></h1>");
		out.println("<hr>");
		try (BookDataAccess obj = new BookDataAccess()) {
			List<Book> list = obj.findAll();
			out.println("<center>");
			out.println("<table border=2>");
			out.println("<thead>");
			out.printf("<th>ID</th>");
			out.printf("<th>NAME</th>");
			out.printf("<th>AUTHOR</th>");
			out.printf("<th>SUBJECT</th>");
			out.printf("<th>PRICE</th>");
			out.println("</thead>");

			for (Book book : list) {
				out.println("<tr>");
				out.printf("<td>%s</td>", book.getBookId());
				out.printf("<td>%s</td>", book.getBookName());
				out.printf("<td>%s</td>", book.getBookAuthor());
				out.printf("<td><input type=radio name=subject/>%s</td>", book.getBookSubject());
				out.printf("<td>%s</td>", book.getBookPrice());
				out.println("</tr>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException();
		}
		out.println("<caption><b><u>Displaying the Books Table</u></b></caption>");
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	}
}
