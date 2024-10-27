package com.rajvardhan.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emp")
public class Employee {
	@Id
	private int empno;
	private String ename;
	private String job;
	private Integer mgr;
	private Date hire;
	private Double sal;
	private Double comm;

	@OneToOne(mappedBy ="emp")
	private Address addr;

	public Employee() {// TODO Auto-generated constructor stub
	}

	public Employee(int empno, String ename, String job, Integer mgr, Date hire, Double sal, Double comm,
			Address addr) {
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hire = hire;
		this.sal = sal;
		this.comm = comm;
		this.addr = addr;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Integer getMgr() {
		return mgr;
	}

	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}

	public Date getHire() {
		return hire;
	}

	public void setHire(Date hire) {
		this.hire = hire;
	}

	public Double getSal() {
		return sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	public Double getComm() {
		return comm;
	}

	public void setComm(Double comm) {
		this.comm = comm;
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	public void Display() {
		System.out.println("===============================================");
		System.out.println("Employee Number    ::" + empno);
		System.out.println("Employee Name 	   ::" + ename);
		System.out.println("Employee Job 	   ::" + job);
		System.out.println("Employee  Manager  ::" + mgr);
		System.out.println("Employee HireDate  ::" + hire);
		System.out.println("Employee Salary    ::" + sal);
		System.out.println("Employee Commision ::" + comm);
		System.out.println("===============================================");
	}
}
