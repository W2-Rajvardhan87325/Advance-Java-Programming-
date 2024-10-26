package com.rajvardhan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rajvardhan.entities.FlowerSupport;

@RestController
public class TestController {

	@Autowired
	private RestTemplate reTemplate;

	@GetMapping(value = "/rest1")
	public FlowerSupport restApi1() {
		String url = "https://reqres.in/api/unknown/2";
		FlowerSupport fs = reTemplate.getForObject(url, FlowerSupport.class);
		return fs;
	}

	
}
