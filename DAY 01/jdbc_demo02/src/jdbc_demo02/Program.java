package jdbc_demo02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Program {
	public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/classwork";
	public static final String DB_USER = "W2_87325_Rajvardhan";
	public static final String DB_PASSWD = "manager";

	static {
		try {
			Class.forName(DB_DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the Subject ::");
		String subject = sc.nextLine();
		System.out.print("Enter the Price   ::");
		double price = sc.nextDouble();

		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD)) {
			String sql = "SELECT * FROM books WHERE subject = ? AND price > ?";
			try (PreparedStatement stm = con.prepareStatement(sql)) {
				stm.setString(1, subject);
				stm.setDouble(2, price);
				try (ResultSet rs = stm.executeQuery()) {
					while (rs.next()) {
						int dbId = rs.getInt("id");
						String dbName = rs.getString("name");
						String dbAuthor = rs.getString("author");
						String dbSubject = rs.getString("subject");
						double dbPrice = rs.getDouble("price");
						System.out.printf("%d	|%s	|%s	|%s	|%f	|\n", dbId, dbName, dbAuthor, dbSubject,
								dbPrice);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		sc.close();
	}

}
