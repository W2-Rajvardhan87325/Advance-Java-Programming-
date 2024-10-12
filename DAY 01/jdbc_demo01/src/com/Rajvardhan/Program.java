package com.Rajvardhan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Program {
	static {
		try {
			// 2. Load and register driver -- one time
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static void main(String[] args) throws SQLException {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter price: ");
		String price = sc.nextLine();
		//=======================================================================
		// 3. Create connection
		String url = "jdbc:mysql://localhost:3306/classwork";
		String user = "W2_87325_Rajvardhan";
		String passwd = "manager";
		try (Connection con = DriverManager.getConnection(url, user, passwd)) {
			//===================================================================
			// 4. Create statement
			try (Statement stmt = con.createStatement()) {
				//===============================================================
				// 5. Execute query and process result
				String sql = "SELECT * FROM books WHERE price > " + price;
				System.out.println("SQL: " + sql);
				try (ResultSet rs = stmt.executeQuery(sql)) {
					while (rs.next()) {
						int id = rs.getInt("id");
						String name = rs.getString("name");
						String author = rs.getString("author");
						String subject = rs.getString("subject");
						double pric = rs.getDouble("price");
						System.out.printf("%d, %s, %s, %s, %f\n", id, name, author, subject, pric);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		sc.close();
	}
}
