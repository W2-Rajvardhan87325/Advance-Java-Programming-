package com.rajvardhan.entities;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.rajvardhan.contracts.Senderable;

@Primary
@Component
public class TcpSender implements Senderable{
	@Override
	public void send(double value) {
		System.out.println("TCP Sender  ::"+value);
	}

}
