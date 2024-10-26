package com.rajvardhan.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	@ManyToOne(fetch = FetchType.EAGER,
			cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name = "deptno")
	private Department Dept;

	public Employee() {
	}


	public Employee(int empno, String ename, String job, Integer mgr, Date hire, Double sal, Double comm,
			Department dept) {
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hire = hire;
		this.sal = sal;
		this.comm = comm;
		Dept = dept;
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


	public Department getDept() {
		return Dept;
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


	public void setDept(Department dept) {
		Dept = dept;
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
		Dept.Display();
		System.out.println("===============================================");
	}

}
