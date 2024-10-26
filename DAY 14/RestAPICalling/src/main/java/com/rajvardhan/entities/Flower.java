package com.rajvardhan.entities;

import java.sql.Date;

public class Flower {

	private int id;
	private String name;
	private Date year;
	private String color;
	private String pantone_value;

	public Flower() {

	}

	public Flower(int id, String name, Date year, String color, String pantone_value) {
		this.id = id;
		this.name = name;
		this.year = year;
		this.color = color;
		this.pantone_value = pantone_value;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getYear() {
		return year;
	}

	public String getColor() {
		return color;
	}

	public String getPantone_value() {
		return pantone_value;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setYear(Date year) {
		this.year = year;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setPantone_value(String pantone_value) {
		this.pantone_value = pantone_value;
	}

	void Display() {
		System.out.println("Flower ID 	   ::" + id);
		System.out.println("Flower Name    ::" + name);
		System.out.println("Flower Year    ::" + year);
		System.out.println("Flower Color   ::" + color);
		System.out.println("Flower P_value ::" + pantone_value);
	}

}
