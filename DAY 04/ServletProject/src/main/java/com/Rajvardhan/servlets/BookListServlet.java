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
@WebServlet(value = "/booklist")

public class BookListServlet extends HttpServlet {
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
		
		// Content Type HTML
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		//HTML Head
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Books List Page</title>");
		out.println("</head>");
		
		//HTML Body
		out.println("<body>");
		out.println("<hr>");
		out.println("<h3><center>ADMIN PANEL<center></h3>");
		out.println("<hr>");
		
		try (BookDataAccess obj = new BookDataAccess()) {
			List<Book> list = obj.findAll();
			out.println("<center>");
			out.println("<fieldset>");
			out.println("<table border='1' cellpadding='10'>");
			out.println("<thead>");
			out.printf("<th>ID</th>");
			out.printf("<th>NAME</th>");
			out.printf("<th>AUTHOR</th>");
			out.printf("<th>SUBJECT</th>");
			out.printf("<th>PRICE</th>");
			out.printf("<th>EDIT</th>");
			out.printf("<th>DELETE</th>");
			out.println("</thead>");

			for (Book book : list) {
				out.println("<tr>");
				out.printf("<td>%s</td>", book.getBookId());
				out.printf("<td>%s</td>", book.getBookName());
				out.printf("<td>%s</td>", book.getBookAuthor());
				out.printf("<td>%s</td>", book.getBookSubject());
				out.printf("<td>%s</td>", book.getBookPrice());
				//Setting the images as hyperlink in the Table.
				out.printf(
						"<td align='center'><a href='editbook?bookId=%d'><img src='images/Edit.png' alt='Edit' width='26' height='26'/></a></td>",
						book.getBookId());
				out.printf(
						"<td align='center'><a href='delbook?bookId=%d'><img src='images/Delete.png' alt='Delete' width='28' height='28'/></a></td>",
						book.getBookId());
				out.println("</tr>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException();
		}
		out.println("</table>");
		String message = (String) req.getAttribute("msg");
		if (message != null)
			out.println("<h5>" + message + "</h5>");
		out.println("</fieldset>");
		out.println("</center>");
		out.println("<br>");
		
		//HTML Footer
		//Creating the table for 2 buttons
		out.printf("<table align='center' cellpadding='10'>\r\n");
		out.printf("<tr>\r\n");		
		out.printf("<td>\r\n");
		out.printf("<p><a href='/ServletProject/pages/Logout.html'><button>Sign Out</button></a></p>\r\n");
		out.printf("</td>\r\n");
		out.printf("<td>\r\n");
		out.printf("<p><a href='/ServletProject/pages/AddBook.html'><button>Add Book</button></a></p>\r\n");
		out.printf("</td>\r\n");
		out.printf("</tr>\r\n");
		
		out.printf("</table>\r\n");
		out.println("</body>");
		out.println("</html>");

	}
}
