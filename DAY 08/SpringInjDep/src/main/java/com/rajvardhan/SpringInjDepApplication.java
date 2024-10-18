package com.rajvardhan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.config")
@SpringBootApplication
public class SpringInjDepApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringInjDepApplication.class, args);
	}

	@Autowired
	private ApplicationContext ctx;

	@Override
	public void run(String... args) throws Exception {
		Personable p1 = (Personable) ctx.getBean("pbAnno1");
		System.out.println("Person Data ::" + p1);


	}
}
