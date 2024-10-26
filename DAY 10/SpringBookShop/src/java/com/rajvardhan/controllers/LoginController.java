package com.rajvardhan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.rajvardhan.contracts.CustomerServicable;
import com.rajvardhan.entities.Customer;
import com.rajvardhan.models.Credentials;

@Controller
public class LoginController {
	@Autowired
	private CustomerServicable cServicable;
	
	public String authenticate(Credentials cr) {
		Customer cust = cServicable.authenticate(cr);
		if(cust == null)
			return "failed";
		return "welcome";
	}
}
