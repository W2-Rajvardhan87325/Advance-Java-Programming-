/**
 * Course: Mobile Computing (DMC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Oct 21, 2024
 */

package com.sunbeam.daos;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.sunbeam.entities.Customer;

@Component
public class CustomerRowMapper implements RowMapper<Customer> {
	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		int id = rs.getInt("id");
		String name = rs.getString("name");
		String mobile = rs.getString("mobile");
		String address = rs.getString("address");
		String password = rs.getString("password");
		String email = rs.getString("email");
		Date birth = rs.getDate("birth");
		Customer c = new Customer(id, name, password, email, address, mobile, birth);
		return c;
	}	
}
