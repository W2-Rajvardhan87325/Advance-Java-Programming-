package com.rajvardhan.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
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
	private int deptno;

	public Employee() {
	}

	public Employee(int empno, String ename, String job, Integer mgr, Date hire, Double sal, Double comm, int deptno) {
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hire = hire;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}

	public int getEmpno() {
		return empno;
	}

	public String getEname() {
		return ename;
	}

	public String getJob() {
		return job;
	}

	public Integer getMgr() {
		return mgr;
	}

	public Date getHire() {
		return hire;
	}

	public Double getSal() {
		return sal;
	}

	public Double getComm() {
		return comm;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}

	public void setHire(Date hire) {
		this.hire = hire;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	public void setComm(Double comm) {
		this.comm = comm;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
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
		System.out.println("Employee Department::" + deptno);
		System.out.println("===============================================");
	}

}
