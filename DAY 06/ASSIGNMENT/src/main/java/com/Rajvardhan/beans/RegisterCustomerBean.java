package com.Rajvardhan.beans;

import java.sql.Date;

import com.Rajvardhan.dataaccess.CustomerDataAccess;
import com.Rajvardhan.entities.Customer;

public class RegisterCustomerBean {
	private String name;
	private String password;
	private String mobile;
	private String address;
	private String email;
	private String birth;
	private Customer cust;
	
	public RegisterCustomerBean() {
		cust=null;
	}
	
	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getMobile() {
		return mobile;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public String getBirth() {
		return birth;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	public boolean saveData() {
		Date date=Date.valueOf(birth);
		cust =new Customer(0, name, mobile, birth, address, email, date);
		try (CustomerDataAccess obj = new CustomerDataAccess()) {
			 obj.save(cust);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
