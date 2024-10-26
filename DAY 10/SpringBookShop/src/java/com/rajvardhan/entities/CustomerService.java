package com.rajvardhan.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajvardhan.contracts.CustomerDaoable;
import com.rajvardhan.contracts.CustomerServicable;
import com.rajvardhan.models.Credentials;

@Service
public class CustomerService implements CustomerServicable {
	@Autowired
	private CustomerDaoable custDao;
	
	@Override
	public Customer authenticate(Credentials cr) {
		Customer dbCust = custDao.findByEmail(cr.getEmail());
		if(dbCust != null && dbCust.getCustPsswd().equals(cr.getPassword()))
			return dbCust;
		return null;
	}
}