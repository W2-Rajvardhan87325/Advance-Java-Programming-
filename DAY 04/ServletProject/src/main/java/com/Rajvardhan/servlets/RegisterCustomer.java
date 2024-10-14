package com.Rajvardhan.servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Rajvardhan.dataaccess.CustomerDataAccess;
import com.Rajvardhan.entities.Customer;

@SuppressWarnings("serial")
@WebServlet(
		value="/registercust",
		loadOnStartup = 2)
public class RegisterCustomer extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		String mobile=req.getParameter("mobile");
		String address=req.getParameter("address");
		String email=req.getParameter("email");
		String birth=req.getParameter("birth");
		Date birthdate=Date.valueOf(birth);
	
		
		Customer cust=new Customer(0, name, password, mobile, address, email, birthdate);
		try (CustomerDataAccess custdao = new CustomerDataAccess()) {
			int count = custdao.save(cust);
			if (count==1) {
				resp.sendRedirect("/ServletProject/pages/RegisterSuccess.html");
			} else {
				resp.sendRedirect("/ServletProject/pages/RegisterFailed.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException();
		}
		

	}
}
