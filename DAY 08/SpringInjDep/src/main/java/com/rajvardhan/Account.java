package com.rajvardhan;

public class Account implements Accountable{
	private String accountId;
	private String accType;
	private double balance;
	Personable accountHolder;
	
	
	public Account() {
	}

	public Account(String accountId, String accType, double balance, Personable accountHolder) {
		this.accountId = accountId;
		this.accType = accType;
		this.balance = balance;
		this.accountHolder = accountHolder;
	}
	
	public String getAccountId() {
		return accountId;
	}

	public String getAccType() {
		return accType;
	}

	public double getBalance() {
		return balance;
	}

	public Personable getAccountHolder() {
		return accountHolder;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setAccountHolder(Personable accountHolder) {
		this.accountHolder = accountHolder;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accType=" + accType + ", balance=" + balance + ", accountHolder="
				+ accountHolder + "]";
	}

	@Override
	public void deposit(float amount) {
		this.balance=this.balance+amount;
		
	}

	@Override
	public void withDraw(float amount) {
		this.balance=this.balance-amount;
		
	}


	
	
}
