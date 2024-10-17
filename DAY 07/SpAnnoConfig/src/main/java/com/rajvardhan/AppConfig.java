package com.rajvardhan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public Box b1(){
		Box bx = new Box();
		bx.setLength(10);
		bx.setBreadth(20);
		bx.setHeight(30);
		return bx;
	}

	@Bean
	public Box b2(){
		Box bx = new Box(10, 12,4);
		return bx;
	}
}
