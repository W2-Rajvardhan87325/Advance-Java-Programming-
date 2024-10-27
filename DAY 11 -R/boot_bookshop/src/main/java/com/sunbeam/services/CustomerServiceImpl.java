/**
 * Course: Mobile Computing (DMC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Oct 21, 2024
 */

package com.sunbeam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.CustomerDao;
import com.sunbeam.entities.Customer;
import com.sunbeam.models.Credentials;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao custDao;
	
	@Override
	public Customer authenticate(Credentials cr) {
		Customer dbCust = custDao.findByEmail(cr.getEmail());
		if(dbCust != null && dbCust.getPassword().equals(cr.getPassword()))
			return dbCust;
		return null;
	}
	
	@Override
	public int saveUser(Customer cust) {
		int count = custDao.save(cust);
		return count;
	}
}
