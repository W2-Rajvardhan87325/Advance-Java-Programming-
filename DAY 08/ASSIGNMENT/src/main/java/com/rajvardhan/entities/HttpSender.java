package com.rajvardhan.entities;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.rajvardhan.contracts.Senderable;


@Component
public class HttpSender implements Senderable{
	@Override
	public void send(double value) {
		System.out.println("HTTP Sender ::"+value);	
	}

}
