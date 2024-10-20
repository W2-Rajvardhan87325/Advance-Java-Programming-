package com.Rajvardhan.dataaccess;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Rajvardhan.entities.Customer;

public class CustomerDataAccess implements AutoCloseable{
	private Connection con;
	
	public CustomerDataAccess() throws Exception {
		con = MysqlConnection.getConnection();
	}
	
	@Override
	public void close() throws Exception {
		if(con != null)
			con.close();
	}
	
	
	public List<Customer> findAllCustomer() throws Exception {
		List<Customer> list = new ArrayList<Customer>();
		String sql = "SELECT * FROM customers";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			try(ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String mobile = rs.getString("mobile");
					String address = rs.getString("address");
					String password = rs.getString("password");
					String email = rs.getString("email");
					Date birth = rs.getDate("birth");
					Customer c = new Customer(id, name, password, email, address, mobile, birth);
					list.add(c);
				}
			} 
		} 
		return list;
	}

	public Customer findByEmail(String email) throws Exception {
		Customer c=new Customer();
		String sql = "SELECT * FROM customers WHERE email = ?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, email);
			try(ResultSet rs = stmt.executeQuery()) {
				if(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String mobile = rs.getString("mobile");
					String address = rs.getString("address");
					String password = rs.getString("password");
					email = rs.getString("email");
					Date birth = rs.getDate("birth");
					c = new Customer(id, name, password, email, address, mobile, birth);
				}
			} 
		} 
		return c;
	}
	
	public int save(Customer c) throws Exception {
		String sql = "INSERT INTO customers (name, address, mobile, email, password, birth) VALUES (?, ?, ?, ?, ?, ?)";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, c.getCustName());
			stmt.setString(2, c.getCustAddr());
			stmt.setString(3, c.getCustMob());
			stmt.setString(4, c.getCustMail());
			stmt.setString(5, c.getCustPsswd());
			stmt.setDate(6, c.getCustBirth());
			int count = stmt.executeUpdate();
			return count;
		}
	}

}
