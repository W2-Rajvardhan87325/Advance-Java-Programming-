package com.rajvardhan.mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.rajvardhan.entities.Customer;

@Component
public class CustomerRowMapper implements RowMapper<Customer> {
	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		int id = rs.getInt("id");
		String name = rs.getString("name");
		String password = rs.getString("password");
		String mobile=rs.getString("mobile");
		String address = rs.getString("address");
		String email = rs.getString("email");
		Date brith = rs.getDate("birth");
		Customer c=new Customer(id, name, password, mobile, address, email, brith);
		return c;
	}
}
