package com.rajvardhan.entities;

import org.springframework.stereotype.Component;

import com.rajvardhan.contracts.Senderable;

@Component
public class UdpSender implements Senderable {

	@Override
	public void send(double value) {
		System.out.println("UDP Sender  ::" + value);

	}

}
