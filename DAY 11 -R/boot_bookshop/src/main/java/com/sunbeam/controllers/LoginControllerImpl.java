/**
 * Course: Mobile Computing (DMC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Oct 21, 2024
 */

package com.sunbeam.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunbeam.entities.Book;
import com.sunbeam.entities.Customer;
import com.sunbeam.models.Credentials;
import com.sunbeam.services.CustomerService;

@Controller
public class LoginControllerImpl {
	@Autowired
	private CustomerService custService;
	
	@RequestMapping("/index")
	public String showLogin() {
		return "index"; // --> /index.jsp
	}
	
	@RequestMapping("/login")
	public String authenticate(Credentials cr, HttpSession session) {
		Customer cust = custService.authenticate(cr);
		if(cust == null)
			return "failed";
		// if user is admin, take to booklist
		if(cust.getName().equalsIgnoreCase("admin"))
			return "redirect:booklist";
		// if user is customer, take to subjects
		// create empty cart to keep selected books
		List<Book> cart = new ArrayList<Book>();
		session.setAttribute("cart", cart);
		return "redirect:subjects";
	}
	
	@RequestMapping("/logout")
	public String signOut(HttpSession session) {
		session.invalidate();
		return "logout"; // --> /logout.jsp
	}
	
	@GetMapping("/register")
	public String newUser(Model model) {
		Customer c = new Customer(0, "", "", "", "", "", null);
		model.addAttribute("cust", c);
		return "newuser";
	}
	
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("cust") Customer cust, BindingResult res, Model model) {
		System.out.println("New Customer -> " + cust);
		if(res.hasErrors()) { // if any validation errors found, return back to original page
			System.out.println("Validation Errors: " + res);
			return "newuser";
		}
		try {
			int count = custService.saveUser(cust);
			model.addAttribute("message", "Customer Registered.");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "Customer Registration Failed.");
		}
		return "newuser";
	}
}







