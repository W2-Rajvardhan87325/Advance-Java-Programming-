package com.rajvardhan.entities;

import org.springframework.stereotype.Component;

import com.rajvardhan.contracts.Loggerable;

@Component
public class ConsoleLogger implements Loggerable {

	@Override
	public void print(String msg) {
		System.out.println("Console Logger ::"+msg);
	}

}
