package com.rajvardhan;

public interface Accountable {
	public String getAccountId();
	public String getAccType();
	public double getBalance();
	
	public void setAccountId(String accountId);
	public void setAccType(String accType);
	public void setBalance(double salary);
	
	public void deposit(float amount);
	public void withDraw(float amount);
	
}
