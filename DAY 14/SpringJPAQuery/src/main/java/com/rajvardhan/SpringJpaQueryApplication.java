package com.rajvardhan;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rajvardhan.contracts.EmployeeDaoable;
import com.rajvardhan.entities.Employee;

@SpringBootApplication
public class SpringJpaQueryApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaQueryApplication.class, args);
	}

	@Autowired
	private EmployeeDaoable daoable;

	@Override
	public void run(String... args) throws Exception {
		int choice, empno, deptno;
		Integer manager;
		String ename, job, temp;
		Double sal, comm;
		Date date;

		Employee e = null;
		List<Employee> list=new ArrayList<Employee>();

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("===============MENU DRIVEN=================");
			System.out.println("1. Find all Employees");
			System.out.println("2. Find Employee by ID");
			System.out.println("3. Insert Employee");
			System.out.println("4. Find by Job ");
			System.out.println("5. Search Employee by name.");
			System.out.println("6. Exit");

			System.out.print("\nENTER YOUR CHOICE ::");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				System.out.println("\t\t\t*********DISPLAYING***********");
				list = daoable.findAll();
				for (Employee emp : list) {
					emp.Display();
				}
				break;

			case 2:
				System.out.println("\t\t\t*********FIND BY ID***********");
				System.out.print("Enter the Employee ID ::");
				empno = sc.nextInt();
				Optional<Employee> obj = daoable.findById(empno);
				e = obj.orElse(null);
				if (e != null) {
					System.out.println("Element found...!");
					e.Display();
				} else {
					System.out.println("Element not found...!");
				}
				break;

			case 3:
				System.out.println("\t\t\t*********INSERT EMPLOYEE***********");
				System.out.print("Enter the Employee ID    ::");
				empno = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter the Employee Name  ::");
				ename = sc.nextLine();
				System.out.print("Enter the Employee Job   ::");
				job = sc.nextLine();
				System.out.print("Enter the Manager Code   ::");
				manager = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter the  HireDate      ::");
				temp = sc.nextLine();
				date = Date.valueOf(temp);
				System.out.print("Enter the Employee Salary::");
				sal = sc.nextDouble();
				System.out.print("Enter the Emp Commission ::");
				comm = sc.nextDouble();
				System.out.print("Enter the Emp Department ::");
				deptno = sc.nextInt();

				e = new Employee(empno, ename, job, manager, date, sal, comm, deptno);
				Employee obj1 = daoable.save(e);
				if (obj1 != null) {
					System.out.println("Employee Inserted Successfully..!");
				} else {
					System.out.println("Invaild Values Inserted..!Try Again");
				}
				break;
			case 4:
				System.out.println("\t\t\t*********FIND BY JOB***********");
				System.out.print("Enter the Employee Job ::");
				job = sc.nextLine();
				list = daoable.findByJob(job);
				if (!list.isEmpty()) {
					System.out.println("Employee Found...!");
					for (Employee emp : list) {
						emp.Display();
					}
				} else {
					System.out.println("Employye not found with that particular job");
				}
				break;
				
			case 5:
				System.out.println("\t\t\t*********SEARCH BY NAME***********");
				System.out.print("Enter the Employee Name ::");
				ename = sc.nextLine();
				list=daoable.findByEnameStartsWith(ename);
				if (!list.isEmpty()) {
					System.out.println("Employee Found...!");
					for (Employee emp : list) {
						emp.Display();
					}
				} else {
					System.out.println("Employye not found with that particular name");
				}
				break;

			default:
				System.out.println("Exiting the code....!");
				System.exit(0);
				break;
			}

		}
	}

}
