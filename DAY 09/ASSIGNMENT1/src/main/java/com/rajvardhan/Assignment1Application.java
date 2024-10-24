package com.rajvardhan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.rajvardhan.contracts.Accountable;
import com.rajvardhan.contracts.Loggerable;
import com.rajvardhan.entities.ConsoleLogger;

@SpringBootApplication
public class Assignment1Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Assignment1Application.class, args);
	}
	
	@Autowired
	private ApplicationContext ctx;

	@Override
	public void run(String... args) throws Exception {

		Loggerable log=ctx.getBean(Loggerable.class);
		log.log("Which Implementation will get called..!");
	}

}
