package com.sunbeam;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommerceJpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceJpaApplication.class, args);
	}

	@Autowired
	private ProductDao prodDao;
	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("Name: ");
		String name = sc.next();
		System.out.print("Description: ");
		String desc = sc.next();
		System.out.print("Price: ");
		double price = sc.nextDouble();
		System.out.print("Stock: ");
		int stock = sc.nextInt();
		Product p = new Product(0, name, desc, price, stock);
		p = prodDao.save(p);
		System.out.println("Product Saved: " + p);
	}
}




