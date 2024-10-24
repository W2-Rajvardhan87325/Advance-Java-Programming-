package com.rajvardhan.daos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rajvardhan.contracts.CustomerDaoable;
import com.rajvardhan.entities.Customer;
import com.rajvardhan.mapper.CustomerRowMapper;

@Repository
public class CustomerDataAccess implements CustomerDaoable {

	@Autowired
	private JdbcTemplate jdbcTemp;

	@Autowired
	private CustomerRowMapper custrowmap;

	@Override
	public List<Customer> findAllCustomer() {
		List<Customer> list = new ArrayList<Customer>();
		String sql = "SELECT * FROM customers";
		list = jdbcTemp.query(sql, custrowmap);
		return list;
	}

	@Override
	public Customer findByEmail(String email) {
		String sql = "SELECT * FROM customers WHERE email = ?";
		Customer cust = jdbcTemp.queryForObject(sql, custrowmap, email);
		return cust;
	}

	@Override
	public int save(Customer c) {
		String sql = "INSERT INTO customers (name, address, mobile, email, password, birth) VALUES (?, ?, ?, ?, ?, ?)";
		int count = jdbcTemp.update(sql, c.getCustName(), c.getCustAddr(), c.getCustMob(), c.getCustMail(),
				c.getCustPsswd(), c.getCustBirth());
		return count;
	}

}
