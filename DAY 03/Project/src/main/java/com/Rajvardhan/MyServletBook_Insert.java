package com.Rajvardhan;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bookinsert")
@SuppressWarnings("serial")
public class MyServletBook_Insert extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("name");
		String author = req.getParameter("author");
		String subject = req.getParameter("subject");
		double price = Double.parseDouble(req.getParameter("price"));
		
		Book b =new Book(0, name, author, subject, price);
		
		try(BookDataAccess obj= new BookDataAccess()){
		int count=obj.save(b);	
		if(count==1) {
			out.println("<b>Data Inserted Successfully..!<b>");	
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Books Table</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<hr>");
			out.println("<h1><center>DISPLAYING TABLE<center></h1>");
			out.println("<hr>");
			try (BookDataAccess obj1 =new BookDataAccess()) {
				List<Book> list = obj1.findAll();
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
					out.printf("<td>%s</td>",book.getBookId());
					out.printf("<td>%s</td>",book.getBookName());
					out.printf("<td>%s</td>",book.getBookAuthor());
					out.printf("<td>%s</td>",book.getBookSubject());
					out.printf("<td>%s</td>",book.getBookPrice());
					out.println("</tr>");
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException();
			}
			out.println("</table>");
			out.println("</center>");
			out.println("</body>");
			out.println("</html>");
		}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException();
		}
		
	}

}
