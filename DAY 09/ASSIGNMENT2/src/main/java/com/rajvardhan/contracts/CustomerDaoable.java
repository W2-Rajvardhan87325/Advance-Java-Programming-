package com.rajvardhan.contracts;

import java.util.List;

import com.rajvardhan.entities.Customer;

public interface CustomerDaoable {
	public List<Customer> findAllCustomer();
	public Customer findByEmail(String email);
	public int save(Customer c);
}
