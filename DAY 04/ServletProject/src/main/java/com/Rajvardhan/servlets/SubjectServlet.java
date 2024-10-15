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

@SuppressWarnings("serial")
@WebServlet(value = "/Subjects", loadOnStartup = 3)
public class SubjectServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("    <meta charset=\"UTF-8\">");
		out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		out.println("    <title>Subject Page</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<center><hr><h3>DISPLAY SUBJECTS</h3><hr></center>");

		out.println("<form action='books' method='POST'>");
		out.println("<fieldset>");
		out.println("<legend><b><u>Select a Subject:</u></b></legend>");
		out.println("<table border='0' cellpadding='10'>");
		try (BookDataAccess obj = new BookDataAccess()) {
			List<String> list = obj.findAllSubjects();
			for (String sub : list) {
				out.println("<tr>");
				out.printf("<td><input type='radio' name='subject' value='%s'/> %s</td>", sub, sub);
				out.println("</tr>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException();
		}

		out.println("</fieldset>");
		out.println("<br>");
		out.println("<tr>");
		out.println("<td><input type='submit' value='Get Books'></td>");
		out.println("</tr>");
		out.println("</form>");
		out.println("<tr>");
		out.println("<td><button><a href=\"showcart\">Show Cart</a></button></td>");
		out.println("</tr>");
		out.println("</body>");
		out.println("</html>");
	}

}
