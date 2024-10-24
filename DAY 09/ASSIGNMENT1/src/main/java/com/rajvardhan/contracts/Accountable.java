package com.rajvardhan.contracts;

public interface Accountable {
	String getAccId();
	String getAccType();
	double getAccBalance();
	Loggerable getLog();
	
	void setAccId(String accId);
	void setAccType(String accType);
	void setAccBalance(double accBalance);
	void setLog(Loggerable log);
	void deposit(double balance);
	void withdraw(double balance);
}
