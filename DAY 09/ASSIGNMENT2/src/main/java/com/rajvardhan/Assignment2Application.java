package com.rajvardhan;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rajvardhan.contracts.BookDaoable;
import com.rajvardhan.contracts.CustomerDaoable;
import com.rajvardhan.entities.Book;
import com.rajvardhan.entities.Customer;

@SpringBootApplication
public class Assignment2Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Assignment2Application.class, args);
	}

	@Autowired
	private BookDaoable bk;
	@Autowired
	private CustomerDaoable cust;

	public void DisplayBook() {
		System.out.printf("\t\t\t******DISPLAYING******\n");
		List<Book> list = bk.findAll();
		for (Book book : list) {
			System.out.println("Printing list----> " + book);
		}
	}

	public void DisplayCustomer() {
		System.out.printf("\t\t\t******DISPLAYING******\n");
		List<Customer> custList = cust.findAllCustomer();
		if (!custList.isEmpty()) {
			for (Customer string : custList) {
				System.out.println("Printing Customer-----> " + string);
			}
		} else {
			System.out.println("Customer doesn't Exists...!");
		}
	}

	@Override
	public void run(String... args) throws Exception {
		int choice, ipid;
		String ipname, ipauthor, ipsubject, ipmail, ippasswd, temp;
		double ipprice;
		Book book = null;
		List<Book> list = new ArrayList<Book>();
		List<Customer> custList = new ArrayList<Customer>();

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("========================MENU DRIVE==========================");
			System.out.println("1. DISPLAY ALL BOOKS.");
			System.out.println("2. INSERT BOOK DATA.");
			System.out.println("3. UPDATE BOOK DETAILS.");
			System.out.println("4. DELETE BOOK DETAILS.");
			System.out.println("5. FIND BY BOOK ID.");
			System.out.println("6. FIND BY BOOK SUBJECT.");
			System.out.println("7. FIND ALL SUBJECTS.");
			System.out.println("8. DISPLAY ALL CUSTOMERS");
			System.out.println("9. FIND CUSTOMER BY EMAIL.");
			System.out.println("10. INSERT CUSTOMER DETAILS");
			System.out.println("11. EXIT");
			System.out.println("=============================================================");
			System.out.print("Enter your choice ::");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				DisplayBook();
				break;

			case 2:
				System.out.printf("\t\t\t******INSERT******\n");
				System.out.print("Enter the Book Name    ::");
				ipname = sc.nextLine();
				System.out.print("Enter the Book Author  ::");
				ipauthor = sc.nextLine();
				System.out.print("Enter the Book Subject ::");
				ipsubject = sc.nextLine();
				System.out.print("Enter the Book Price   ::");
				ipprice = sc.nextDouble();

				book = new Book(0, ipname, ipauthor, ipsubject, ipprice);
				int count = bk.save(book);
				if (count == 1) {
					System.out.println("Book Inserted Successfully..!");
					DisplayBook();
				} else {
					System.out.println("Input MissMatch Error...!");
				}
				break;

			case 3:
				System.out.printf("\t\t\t******UPDATE******\n");
				System.out.print("Book ID (To Update)  ::");
				ipid = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter the Book Name    ::");
				ipname = sc.nextLine();
				System.out.print("Enter the Book Author  ::");
				ipauthor = sc.nextLine();
				System.out.print("Enter the Book Subject ::");
				ipsubject = sc.nextLine();
				System.out.print("Enter the Book Price   ::");
				ipprice = sc.nextDouble();

				book = new Book(ipid, ipname, ipauthor, ipsubject, ipprice);
				count = bk.update(book);
				if (count == 1) {
					System.out.println("Book Updated Successfully..!");
					DisplayBook();
				} else {
					System.out.println("Input MissMatch Error...!");
				}
				break;

			case 4:
				System.out.printf("\t\t\t******DELETE BY ID******\n");
				System.out.print("Book ID (To Delete)  ::");
				ipid = sc.nextInt();
				count = bk.deleteById(ipid);
				if (count == 1) {
					System.out.println("Book Deleted Successfully..!");
					DisplayBook();
				} else {
					System.err.println("Error...! Id not Found");
				}
				break;

			case 5:
				System.out.printf("\t\t\t******FIND BY ID******\n");
				System.out.print("Book ID (To Find)  ::");
				ipid = sc.nextInt();
				book = bk.findById(ipid);
				if (book != null) {
					System.out.println("Printing Book------> " + book);
				} else {
					System.out.println("Book not found...!");
				}
				break;

			case 6:
				System.out.printf("\t\t\t******FIND BY SUBJECT******\n");
				System.out.print("Book Subject (To Find)  ::");
				ipsubject = sc.nextLine();
				list = bk.findBySubject(ipsubject);
				if (!list.isEmpty()) {
					for (Book bk : list) {
						System.out.println("Printing Book------->" + bk);
					}
				} else {
					System.out.println("Book not found for particular subject..!");
				}
				break;

			case 7:
				System.out.printf("\t\t\t******DISPLAYING SUBJECTS******\n");
				List<String> listoFSub = bk.findAllSubjects();
				if (!listoFSub.isEmpty()) {
					for (String string : listoFSub) {
						System.out.println("Printing ---->" + string);
					}
				} else {
					System.out.println("Not Subjects Available;");
				}
				break;

			case 8:
				DisplayCustomer();
				break;

			case 9:
				System.out.printf("\t\t\t******FIND CUSTOMER BY MAIL******\n");
				System.out.print("Enter the Customer email  ::");
				ipmail = sc.nextLine();

				Customer c = cust.findByEmail(ipmail);
				if (c != null) {
					System.out.println("Printing---->" + c);
				} else {
					System.out.println("Customer not exists....!");
				}
				break;

			case 10:
				System.out.printf("\t\t\t******INSERT******\n");
				System.out.print("Enter the Customer Name       ::");
				ipname = sc.nextLine();
				System.out.print("Enter the Customer Address    ::");
				ipauthor = sc.nextLine();
				System.out.print("Enter the Customer Mobile     ::");
				ipsubject = sc.nextLine();
				System.out.print("Enter the Customer Email      ::");
				ipmail = sc.nextLine();
				System.out.print("Enter the Customer Password   ::");
				ippasswd = sc.nextLine();
				System.out.print("Enter the Customer Birth-date(yyyy-mm-dd)   ::");
				temp = sc.nextLine();
				Date ipdate = Date.valueOf(temp);

				c = new Customer(0, ipname, ippasswd, ipsubject, ipauthor, ipmail, ipdate);
				count = cust.save(c);
				if (count == 1) {
					System.out.println("Data Inserted Successfully..!");
					DisplayCustomer();
				} else {
					System.out.println("Error! Re-Enter the values..!");
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
