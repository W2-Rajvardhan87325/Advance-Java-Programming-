package com.rajvardhan;

public class Person implements Personable {
	private String name;
	private String email;
	private String address;
	private String mobile;

	public Person() {
		
	}
	
	public Person(String name, String email, String address, String mobile) {
		this.name = name;
		this.email = email;
		this.address = address;
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", email=" + email + ", address=" + address + ", mobile=" + mobile + "]";
	}

	
}
