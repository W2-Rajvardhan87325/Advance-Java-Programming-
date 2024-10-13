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
		out.println("<h1><center>ASSIGNMENT 01 (DISPLAY SUBJECT WITH RADIO BUTTON)<center></h1>");
		out.println("<hr>");
		try(BookDataAccess obj =new BookDataAccess()) {
			List<String> list = obj.findAllSubjects();
			out.println("<center>");
			out.println("<table border=1>");
			out.println("<thead>");
			out.printf("<th>SUBJECT</th>");
			out.println("</thead>");
			for (String book : list) {
				out.println("<tr>");
				out.printf("<td><input type=radio name=subject/>%s</td>",book);
				out.println("</tr>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException();
		}
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	}
}
