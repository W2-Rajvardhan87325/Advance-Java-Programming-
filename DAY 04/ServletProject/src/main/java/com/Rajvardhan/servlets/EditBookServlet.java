package com.Rajvardhan.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Rajvardhan.dataaccess.BookDataAccess;
import com.Rajvardhan.entities.Book;

@SuppressWarnings("serial")
@WebServlet(value="/editbook")

public class EditBookServlet extends HttpServlet{
	@Override

	// User Defined Service Method
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Content Type HTML
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		//Fetching the bookId from the BooklistServlet.java (In the From of Query-String)
		String bookId = req.getParameter("bookId");
		int id = Integer.parseInt(bookId);
		
		//Accessing the Details using the bookId
		try(BookDataAccess obj=new BookDataAccess()){
			Book bk = obj.findById(id);
			
			//HTML Head
			out.printf("<!DOCTYPE html>\r\n");
			out.printf("<html>\r\n");
			out.printf("<head>\r\n");
			out.printf("<title>New Book</title>\r\n");
			out.printf("</head>\r\n");

			//HTML Body
			out.printf("<hr><h3 align='center'>UPDATE BOOK DETAILS</h3>\n");
			out.printf("<table cellpadding='10'>\n");
			out.printf("<tr><td><button><a href='booklist'>Go Back</a></button></td><td></td><tr>\r\n");
			out.printf("</table>");
			out.printf("<form method='post' action='editbook'>\r\n");
			out.printf("<fieldset>\r\n");
			out.printf("<table cellpadding='10'>\r\n");
			
			//Used to display the values in the Edit page of select Id.
			out.printf("<tr><td><b>Book ID</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</td><td><input type='text' name='id' value='%d' readonly/></td></tr>\r\n", bk.getBookId());
			out.printf("<tr><td><b>Book Name</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</td><td><input type='text' name='name' value='%s'/></td></tr>\r\n",bk.getBookName());
			out.printf("<tr><td><b>Book Author</b>&nbsp;&nbsp;&nbsp;:</td><td><input type='text' name='author' value='%s'/></td></tr>\r\n",bk.getBookAuthor());
			out.printf("<tr><td><b>Book Subject</b>&nbsp;&nbsp;:</td><td><input type='text' name='subject' value='%s'/></td></tr>\r\n",bk.getBookSubject());
			out.printf("<tr><td><b>Book Price</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</td><td><input type='text' name='price' value='%f'/></td></tr>\r\n",bk.getBookPrice());
			out.printf("<tr><td> </td><td><input type='submit' value='Update Book'/></td></tr>\r\n");
			
			//HTML Footer
			out.printf("</table>\r\n");
			out.printf("</fieldset>\r\n");
			out.printf("<br/>\r\n");
			out.printf("</form>\r\n");
			out.printf("</body>\r\n");
			out.printf("</html>\r\n");
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException();
		}
	}

	//Above doGet method generated the POST call on form submission to this doPost method
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Fetching the data from the above form only..!
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String author = req.getParameter("author");
		String subject = req.getParameter("subject");
		double price = Double.parseDouble(req.getParameter("price"));
		
		//Updating the book-details using the update() method
		Book bk = new Book(id, name, author, subject, price);
		try(BookDataAccess obj = new BookDataAccess()) {
			int count = obj.update(bk);
			
			//If book is updated the message is passed to the BooklistServlet.java in the from of req-setAttribute.
			String message = "BOOK UPDATED :: " + count;
			req.setAttribute("msg", message);
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		//Redirecting to BooklistServlet.java.
		RequestDispatcher rd = req.getRequestDispatcher("booklist");
		rd.forward(req, resp);
	}
}
