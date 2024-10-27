package com.rajvardhan;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rajvardhan.contracts.EmployeeDaoable;
import com.rajvardhan.entities.Employee;

@SpringBootApplication
public class SpringJapOneToOneApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringJapOneToOneApplication.class, args);
	}

	@Autowired
	private EmployeeDaoable daoable;

	@Override
	public void run(String... args) throws Exception {

		int choice, empno;

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("===============MENU DRIVEN=================");
			System.out.println("1. Find By ID");

			System.out.print("\nENTER YOUR CHOICE ::");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				System.out.println("\t\t\t*********FIND BY ID***********");
				System.out.print("Enter the Employee ID ::");
				empno = sc.nextInt();

				Optional<Employee> var = daoable.findById(empno);
				Employee emp = var.orElse(null);
				if (emp != null) {
					System.out.println("Employee found....");
					emp.Display();
				} else {
					System.out.println("Employee not found..!");
				}
				break;

			default:
				System.out.println("Exiting Code...!");
				System.exit(0);
				break;
			}
		}
	}

}
