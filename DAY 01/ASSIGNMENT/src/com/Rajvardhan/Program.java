package com.Rajvardhan;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Program {

	public static void displayBook() {
		List<Book> lbk = new ArrayList<Book>();
		try (BookDataAccess obj = new BookDataAccess()) {
			lbk = obj.findAll();
			System.out.printf("\t\t\t******DISPLAYING******\n");
			for (Book book : lbk) {
				System.out.println("Printing -->" + book);
			}
		} catch (Exception e) {
			System.err.println("No any books available..!");
		}
	}

	public static void displayCustomer() {
		List<Customer> lck = new ArrayList<Customer>();
		try (CustomerDataAccess obj = new CustomerDataAccess()) {
			lck = obj.findAllCustomer();
			System.out.printf("\t\t\t******DISPLAYING******\n");
			for (Customer cust : lck) {
				System.out.println("Printing -->" + cust);
			}
		} catch (Exception e) {
			System.err.println("No Customer available..>!");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice, ipid;
		String ipname, ipauthor, ipsubject, ipmail, ippasswd, temp;

		double ipprice;
		do {
			int count = 0;
			List<Book> lbk = new ArrayList<Book>();
			List<String> lbs = new ArrayList<String>();
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
				displayBook();
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
				try (BookDataAccess obj = new BookDataAccess()) {
					count = obj.save(new Book(0, ipname, ipauthor, ipsubject, ipprice));
					if (count == 1)
						System.out.println("Book Inserted Successfully..!");
					displayBook();
				} catch (Exception e) {
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

				try (BookDataAccess obj = new BookDataAccess()) {
					count = obj.update(new Book(ipid, ipname, ipauthor, ipsubject, ipprice));
					if (count == 1)
						System.out.println("Book Updated Successfully..!\n");
					else
						System.out.printf("Error 404 Id not found...!\n");
					displayBook();
				} catch (Exception e) {
					System.err.println("Failed ...to Update (Input Match)");
				}
				break;
			case 4:
				System.out.printf("\t\t\t******DELETE BY ID******\n");
				System.out.print("Book ID (To Delete)  ::");
				ipid = sc.nextInt();
				try (BookDataAccess obj = new BookDataAccess()) {
					count = obj.deleteById(ipid);
					if (count == 1)
						System.out.println("Book Deleted Successfully..!");
					displayBook();
				} catch (Exception e) {
					System.err.println("Error...! Id not Found");
				}
				break;

			case 5:
				System.out.printf("\t\t\t******FIND BY ID******\n");
				System.out.print("Book ID (To Find)  ::");
				ipid = sc.nextInt();
				try (BookDataAccess obj = new BookDataAccess()) {
					Book b = obj.findById(ipid);
					System.out.println(b.toString());
				} catch (Exception e) {
					System.err.println("Error...! Id not Found");
				}
				break;

			case 6:
				System.out.printf("\t\t\t******FIND BY SUBJECT******\n");
				System.out.print("Book Subject (To Find)  ::");
				ipsubject = sc.nextLine();
				try (BookDataAccess obj = new BookDataAccess()) {
					lbk = obj.findBySubject(ipsubject);
					for (Book book : lbk) {
						System.out.println("Printing -->" + book);
					}
				} catch (Exception e) {
					System.err.println("Error...! Id not Found");
				}
				break;

			case 7:
				System.out.printf("\t\t\t******DISPLAYING SUBJECTS******\n");
				try (BookDataAccess obj = new BookDataAccess()) {
					lbs = obj.findAllSubjects();
					for (String string : lbs) {
						System.out.println("Printing -->" + string);
					}
				} catch (Exception e) {
					System.err.println("No subjects are Available...!");
				}
				break;
			case 8:
				displayCustomer();
				break;
			case 9:
				System.out.printf("\t\t\t******FIND CUSTOMER BY MAIL******\n");
				System.out.print("Enter the Customer email  ::");
				ipname = sc.nextLine();
				try (CustomerDataAccess obj = new CustomerDataAccess()) {
					Customer c = obj.findByEmail(ipname);
					System.out.println("Printing-->" + c);
				} catch (Exception e) {
					System.err.println("No Customer available..>!");
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

				try (CustomerDataAccess obj = new CustomerDataAccess()) {
					count = obj.save(new Customer(0, ipname, ippasswd, ipsubject, ipauthor, ipmail, ipdate));
					if (count == 1)
						System.out.println("Customer Inserted Successfully..!");
					displayCustomer();
				} catch (Exception e) {
					System.out.println("Input MissMatch Error...!");
				}
				break;
			default:
				System.out.println("Invalid Choice....!");
				break;
			}

		} while (choice != 11);

		sc.close();
	}
}
