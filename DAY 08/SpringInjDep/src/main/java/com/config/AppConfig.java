package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rajvardhan.Person;

@Configuration
public class AppConfig {
	@Bean
	public Person pbAnno1() {
		Person p = new Person("Raj", "raj@gmail.com", "Kodoli", "9075857927");
		return p;
	}
}
