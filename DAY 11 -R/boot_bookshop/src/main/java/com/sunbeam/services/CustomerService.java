/**
 * Course: Mobile Computing (DMC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Oct 21, 2024
 */

package com.sunbeam.services;

import com.sunbeam.entities.Customer;
import com.sunbeam.models.Credentials;

public interface CustomerService {
	Customer authenticate(Credentials cr);
	int saveUser(Customer cust);
}
