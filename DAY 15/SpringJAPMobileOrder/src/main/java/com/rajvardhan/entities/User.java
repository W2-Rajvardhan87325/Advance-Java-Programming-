package com.rajvardhan.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	private int id;
	private String uname;
	private String email;
	private String password;
	private String mobile;

	@OneToMany(mappedBy = "user")
	private List<Order> orderListu;

	public User() {

	}

	public User(int id, String uname, String email, String password, String mobile, List<Order> orderListu) {
		this.id = id;
		this.uname = uname;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.orderListu = orderListu;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public List<Order> getOrderListu() {
		return orderListu;
	}

	public void setOrderListu(List<Order> orderListu) {
		this.orderListu = orderListu;
	}

	void Display() {
		System.out.println("===============================================");
		System.out.println("User ID        ::" + id);
		System.out.println("User Name	   ::" + uname);
		System.out.println("User Email	   ::" + email);
		System.out.println("User Password  ::" + password);
		System.out.println("Mobile Name    ::" + mobile);
		System.out.println("===============================================");
	}
}
