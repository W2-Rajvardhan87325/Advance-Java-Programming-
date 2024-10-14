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
		String[] bookIds = req.getParameterValues("bookName");

		if (bookIds == null || bookIds.length == 0) {
			resp.sendRedirect("/ServletProject/pages/SubjectFailed.html");
		} else {
			HttpSession session = req.getSession();
			@SuppressWarnings("unchecked")
			List<Integer> items = (List<Integer>) session.getAttribute("items");
			for (String book : bookIds) {
				int id = Integer.parseInt(book);
				items.add(id);
			}
			resp.sendRedirect("Subjects");
		}

	}

}
