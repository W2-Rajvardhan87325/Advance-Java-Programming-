package com.rajvardhan.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "mobiles")
public class Mobile {
	@Id
	private int id;
	private String mname;
	private int ram;
	private int storage;
	private String company;
	private Double price;
	private String image;

	@OneToMany(mappedBy = "mobile")
	private List<Order> orderListm;

	public Mobile() {

	}

	public Mobile(int id, String mname, int ram, int storage, String company, Double price, String image) {
		this.id = id;
		this.mname = mname;
		this.ram = ram;
		this.storage = storage;
		this.company = company;
		this.price = price;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public int getStorage() {
		return storage;
	}

	public void setStorage(int storage) {
		this.storage = storage;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Order> getOrderListm() {
		return orderListm;
	}

	public void setOrderListm(List<Order> orderListm) {
		this.orderListm = orderListm;
	}

	void Display() {
		System.out.println("===============================================");
		System.out.println("Mobile ID         ::" + id);
		System.out.println("Mobile Name	      ::" + mname);
		System.out.println("Mobile Ram	      ::" + ram);
		System.out.println("Mobile Storage    ::" + storage);
		System.out.println("Mobile Company    ::" + company);
		System.out.println("Mobile Price      ::" + price);
		System.out.println("Mobile Image Name ::" + image);
		System.out.println("===============================================");
	}
}
