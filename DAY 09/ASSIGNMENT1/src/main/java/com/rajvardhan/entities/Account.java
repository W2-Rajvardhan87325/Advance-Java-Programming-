package com.rajvardhan.entities;

import org.springframework.beans.factory.annotation.Autowired;

import com.rajvardhan.contracts.Accountable;
import com.rajvardhan.contracts.Loggerable;

public class Account implements Accountable {
	private String accId;
	private String accType;
	private double accBalance;
	@Autowired
	private Loggerable log;
	
	public Account() {
		log=null;
	}

	public Account(String accId, String accType, double accBalance, Loggerable log) {
		this.accId = accId;
		this.accType = accType;
		this.accBalance = accBalance;
		this.log = log;
	}

	public String getAccId() {
		return accId;
	}

	public String getAccType() {
		return accType;
	}

	public double getAccBalance() {
		return accBalance;
	}

	public Loggerable getLog() {
		return log;
	}

	public void setAccId(String accId) {
		this.accId = accId;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}

	public void setLog(Loggerable log) {
		this.log = log;
	}

	@Override
	public String toString() {
		return "Account [accId=" + accId + ", accType=" + accType + ", accBalance=" + accBalance + ", log=" + log + "]";
	}

	@Override
	public void deposit(double balance) {
		accBalance+=balance;
		System.out.println("Deposited balance Rs."+balance+" total amount ::"+this.accBalance);
	}

	@Override
	public void withdraw(double balance) {
		accBalance-=balance;
		System.out.println("Withdraw balance Rs."+balance+" total amount ::"+this.accBalance);
	}
}
