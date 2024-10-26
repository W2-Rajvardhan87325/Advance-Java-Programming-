package com.rajvardhan.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dept")
public class Department {
	@Id
	private int deptno;
	private String dname;
	private String loc;

	public Department() {

	}

	public Department(int deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}

	public int getDeptno() {
		return deptno;
	}

	public String getDname() {
		return dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	void Display() {
		System.out.println("Department Number   ::" + deptno);
		System.out.println("Department Name     ::" + dname);
		System.out.println("Department Location ::" + loc);
	}

}
