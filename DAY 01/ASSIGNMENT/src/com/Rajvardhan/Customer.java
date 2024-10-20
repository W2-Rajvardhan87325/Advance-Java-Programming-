package com.Rajvardhan;

import java.sql.Date;

public class Customer {

	public int custId;
	public String custName;
	public String custPsswd;
	public String custMob;
	public String custAddr;
	public String custMail;
	public Date custBirth;
	
	public Customer() {
		
	}
	

	public Customer(int custId, String custName, String custPsswd, String custMob, String custAddr, String custMail,
			Date custBirth) {
		this.custId = custId;
		this.custName = custName;
		this.custPsswd = custPsswd;
		this.custMob = custMob;
		this.custAddr = custAddr;
		this.custMail = custMail;
		this.custBirth = custBirth;
	}

	public int getCustId() {
		return custId;
	}

	public String getCustName() {
		return custName;
	}

	public String getCustPsswd() {
		return custPsswd;
	}

	public String getCustMob() {
		return custMob;
	}

	public String getCustAddr() {
		return custAddr;
	}

	public String getCustMail() {
		return custMail;
	}

	public Date getCustBirth() {
		return custBirth;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public void setCustPsswd(String custPsswd) {
		this.custPsswd = custPsswd;
	}

	public void setCustMob(String custMob) {
		this.custMob = custMob;
	}

	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}

	public void setCustMail(String custMail) {
		this.custMail = custMail;
	}

	public void setCustBirth(Date custBirth) {
		this.custBirth = custBirth;
	}	
	
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custPsswd=" + custPsswd + ", custMob="
				+ custMob + ", custAddr=" + custAddr + ", custMail=" + custMail + ", custBirth=" + custBirth + "]";
	}
}
