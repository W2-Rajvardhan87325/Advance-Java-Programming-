package com.Rajvardhan.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Rajvardhan.dataaccess.CustomerDataAccess;
import com.Rajvardhan.entities.Customer;

@SuppressWarnings("serial")
@WebServlet(value = "/login", loadOnStartup = 1)

public class LoginServlet extends HttpServlet {
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
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		HttpSession session = req.getSession();
		try (CustomerDataAccess custdao = new CustomerDataAccess()) {
			Customer cust = custdao.findByEmail(email);
			if (cust != null && password.equals(cust.getCustPsswd())) {
				resp.sendRedirect("Subjects");
		
				List<Integer> items = new ArrayList<Integer>();
				session.setAttribute("items", items);
				
			} else {
				resp.sendRedirect("/ServletProject/pages/LoginFailed.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException();
		}

	}

}
