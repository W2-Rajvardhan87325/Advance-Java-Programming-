/**
 * Course: Mobile Computing (DMC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Oct 27, 2024
 */

package com.sunbeam.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunbeam.entities.User;
import com.sunbeam.models.Credentials;
import com.sunbeam.services.UserService;

@Controller
public class UserControllerImpl {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/index")
	public String loginPage() {
		return "index";
	}
	
	@RequestMapping("/login")
	public String loginUser(Credentials cr, HttpSession session) {
		User user = userService.authenticate(cr);
		if(user == null)
			return "failed";
		session.setAttribute("user", user);
		return "redirect:mobiles";
	}
}
