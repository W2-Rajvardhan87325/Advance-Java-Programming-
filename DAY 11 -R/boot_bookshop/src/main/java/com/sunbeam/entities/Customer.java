package com.sunbeam.entities;

import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Customer {
	private int id;
	@NotEmpty
	private String name;
	@NotBlank
	@Size(min = 4, max = 12)
	private String password;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	private String address;
	@NotBlank
	@Pattern(regexp = "^[0-9]{10}$")
	private String mobile;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birth;
	
	public Customer() {
	}

	public Customer(int id, String name, String password, String email, String address, String mobile, Date birth) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.address = address;
		this.mobile = mobile;
		this.birth = birth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", address="
				+ address + ", mobile=" + mobile + ", birth=" + birth + "]";
	}
}
